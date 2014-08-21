package sample.BL0001;

import jp.terasoluna.fw.batch.openapi.BLogic;
import jp.terasoluna.fw.batch.openapi.BLogicResult;
import jp.terasoluna.fw.batch.openapi.ReturnCode;

public class BL0001BLogic implements BLogic<BL0001Sale, BL0001JobContext> {

	@Override
	public BLogicResult execute(BL0001Sale data, BL0001JobContext jobContext) {
		
		int totalSale = jobContext.getTotalSale();
		
		totalSale = totalSale + data.getPrice();
		
		jobContext.incrementCount();
		jobContext.setTotalSale(totalSale);
		
		return new BLogicResult(ReturnCode.NORMAL_CONTINUE);
	}

}
