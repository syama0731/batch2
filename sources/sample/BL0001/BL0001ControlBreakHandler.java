package sample.BL0001;

import java.util.Map;

import jp.terasoluna.fw.batch.openapi.BLogicResult;
import jp.terasoluna.fw.batch.openapi.ControlBreakHandler;
import jp.terasoluna.fw.batch.openapi.ReturnCode;

public class BL0001ControlBreakHandler implements ControlBreakHandler<BL0001JobContext> {

	@Override
	public BLogicResult handleControlBreak(Map<String, Object> map,
			BL0001JobContext jobContext) {
		
		return new BLogicResult(ReturnCode.NORMAL_CONTINUE);
	}

}
