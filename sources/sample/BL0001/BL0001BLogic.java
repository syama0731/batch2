package sample.BL0001;

import sample.exception.SampleException;
import jp.terasoluna.fw.batch.openapi.BLogic;
import jp.terasoluna.fw.batch.openapi.BLogicResult;
import jp.terasoluna.fw.batch.openapi.ReturnCode;
import jp.terasoluna.fw.dao.UpdateDAO;
import jp.terasoluna.fw.file.dao.FileLineWriter;

public class BL0001BLogic implements BLogic<BL0001Sale, BL0001JobContext> {

	private UpdateDAO updateDAO = null;
	
	private FileLineWriter<BL0001Sale> fileLineWriter = null;
	
	public void setUpdateDAO(UpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}
	
	public void setFileLineWriter(FileLineWriter<BL0001Sale> fileLineWriter) {
		this.fileLineWriter = fileLineWriter;
	}
	
	@Override
	public BLogicResult execute(BL0001Sale data, BL0001JobContext jobContext) {
		
//		throw new SampleException("SampleException");
		
		int totalSale = jobContext.getTotalSale();
		
		totalSale = totalSale + data.getPrice();
		
		jobContext.incrementCount();
		jobContext.setTotalSale(totalSale);
		
		//fileLineWriter.printDataLine(data);
		
		updateDAO.execute("BL0001.insertSales", data);
		
		return new BLogicResult(ReturnCode.NORMAL_CONTINUE);
	}

}
