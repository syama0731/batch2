package sample.BL0001;

import jp.terasoluna.fw.batch.openapi.BLogic;
import jp.terasoluna.fw.batch.openapi.BLogicResult;
import jp.terasoluna.fw.batch.openapi.ReturnCode;

public class BL0001 implements BLogic<BL0001Data, BL0001JobContext> {

	@Override
	public BLogicResult execute(BL0001Data data, BL0001JobContext jobContext) {
		
		return new BLogicResult(ReturnCode.NORMAL_CONTINUE);
	}

}
