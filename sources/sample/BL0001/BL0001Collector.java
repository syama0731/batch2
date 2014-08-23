package sample.BL0001;

import jp.terasoluna.fw.batch.core.AbstractCollector;
import jp.terasoluna.fw.batch.core.CollectedDataHandler;
import jp.terasoluna.fw.batch.core.CollectorResult;
import jp.terasoluna.fw.batch.core.JobStatus;
import jp.terasoluna.fw.batch.openapi.ReturnCode;
import jp.terasoluna.fw.file.dao.FileLineIterator;
import jp.terasoluna.fw.file.dao.FileQueryDAO;

public class BL0001Collector extends AbstractCollector<BL0001JobContext> {

	private FileQueryDAO fileQueryDAO = null;
	
	private String inputFileName = null;
	
	private Object resultClass = null;
	
	public void setFileQueryDAO(FileQueryDAO fileQueryDAO) {
		this.fileQueryDAO = fileQueryDAO;
	}
	
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}
	
	public void setResultClass(Object resultClass) {
		this.resultClass = resultClass;
	}
	
	@Override
	protected CollectorResult doCollect(BL0001JobContext jobContext,
			CollectedDataHandler collectedDataHandler, JobStatus jobStatus) {
		
		int collected = 0;
		
		FileLineIterator<? extends Object> fileLineIterator = fileQueryDAO.execute(inputFileName, resultClass.getClass());
		
		while(fileLineIterator.hasNext()) {
			BL0001Sale data = (BL0001Sale) fileLineIterator.next();
			
			int offset = 0;
			
			while (jobContext.getPreview().getId() != data.getId() - 1) {
				BL0001Sale dummy = new BL0001Sale();
				dummy.setId(jobContext.getPreview().getId() + ++offset);
				dummy.setItem(jobContext.getPreview().getItem());
				dummy.setPrice(jobContext.getPreview().getPrice());
				dummy.setCustomer(jobContext.getPreview().getCustomer());				
				
				jobContext.setPreview(dummy);

				collectedDataHandler.handle(dummy, collected);
				jobStatus.incrementCollected();				
			}
			
			jobContext.setPreview(data);
			
			collectedDataHandler.handle(data, collected);
			jobStatus.incrementCollected();
			
		}
		
		return new CollectorResult(ReturnCode.NORMAL_END, collected);
	}

}
