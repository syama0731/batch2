package sample.BL0001;

import jp.terasoluna.fw.batch.openapi.JobContext;

public class BL0001JobContext extends JobContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5682269334191909805L;

	
	private int count = 0;
	
	private BL0001Sale preview = new BL0001Sale();
	
	private int totalSale = 0;
	
	public int getCount() {
		return this.count;
	}
	
	public BL0001Sale getPreview() {
		return this.preview;
	}
	
	public void incrementCount() {
		this.count++;
	}
	
	public void setPreview(BL0001Sale preview) {
		this.preview = preview;
	}
	
	public void resetCount() {
		this.count = 0;
	}
	
	public void resetTotalSale() {
		this.totalSale = 0;
	}

	public int getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(int totalSale) {
		this.totalSale = totalSale;
	}
	
}
