package sample.BL0001;

import jp.terasoluna.fw.batch.openapi.BLogic;
import jp.terasoluna.fw.batch.openapi.BLogicResult;
import jp.terasoluna.fw.batch.openapi.ReturnCode;

public class BL0001BLogic implements BLogic<BL0001Data, BL0001JobContext> {

	@Override
	public BLogicResult execute(BL0001Data data, BL0001JobContext jobContext) {
		
		System.out.println(data.getId());
		System.out.println(data.getItem());
		System.out.println(data.getPrice());
		System.out.println(data.getCustomer());
		
		return new BLogicResult(ReturnCode.NORMAL_CONTINUE);
	}

}
