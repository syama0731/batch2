package sample.BL0001;

import java.util.Map;

import jp.terasoluna.fw.batch.openapi.BLogicResult;
import jp.terasoluna.fw.batch.openapi.ControlBreakHandler;
import jp.terasoluna.fw.batch.openapi.ReturnCode;
import jp.terasoluna.fw.dao.UpdateDAO;

public class BL0001ControlBreakHandler implements ControlBreakHandler<BL0001JobContext> {

	
	private UpdateDAO updateDA0 = null;
	

	public void setUpdateDA0(UpdateDAO updateDA0) {
		this.updateDA0 = updateDA0;
	}

	
	@Override
	public BLogicResult handleControlBreak(Map<String, Object> map,
			BL0001JobContext jobContext) {
		
		BL0001ItemSale itemSale = new BL0001ItemSale();
		
		itemSale.setTotalCount(jobContext.getCount());
		itemSale.setTotalSale(jobContext.getTotalSale());
		itemSale.setItem((String)map.get("item"));
		
		updateDA0.execute("BL0001.insertItemSale", itemSale);
		
		jobContext.resetCount();
		jobContext.resetTotalSale();
		
		return new BLogicResult(ReturnCode.NORMAL_CONTINUE);
	}

}
