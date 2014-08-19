package sample.BL0001;

import jp.terasoluna.fw.batch.openapi.BLogicResult;
import jp.terasoluna.fw.batch.openapi.ReturnCode;
import jp.terasoluna.fw.batch.openapi.SupportLogic;

public class BL0001PostBLogic implements SupportLogic<BL0001JobContext> {

	@Override
	public BLogicResult execute(BL0001JobContext jobContext) {
		
		System.out.println("finish BL0001");
		
		return new BLogicResult(ReturnCode.NORMAL_CONTINUE);
	}

}
