package sample.BL0001;

import jp.terasoluna.fw.batch.core.AbstractCollector;
import jp.terasoluna.fw.batch.core.CollectedDataHandler;
import jp.terasoluna.fw.batch.core.CollectorResult;
import jp.terasoluna.fw.batch.core.JobStatus;
import jp.terasoluna.fw.batch.openapi.ReturnCode;

public class BL0001Collector extends AbstractCollector<BL0001JobContext> {

	@Override
	protected CollectorResult doCollect(BL0001JobContext jobContext,
			CollectedDataHandler collectedDataHandler, JobStatus jobStatus) {
		
		int collected = 0;
		
		BL0001Sale data = new BL0001Sale();
		
		collectedDataHandler.handle(data, collected);
		jobStatus.incrementCollected();
		
		return new CollectorResult(ReturnCode.NORMAL_END, collected);
	}

}
