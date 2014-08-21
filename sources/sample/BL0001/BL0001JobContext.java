package sample.BL0001;

import jp.terasoluna.fw.batch.openapi.JobContext;

public class BL0001JobContext extends JobContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5682269334191909805L;

	
	private int count = 0;
	
	private int preview = 0;
	
	private int totalSale = 0;
	
	public int getCount() {
		return this.count;
	}
	
	public int getPreview() {
		return this.preview;
	}
	
	public void incrementCount() {
		this.count++;
	}
	
	public void setPreview(int value) {
		this.preview = value;
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
