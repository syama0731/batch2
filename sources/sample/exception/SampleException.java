package sample.exception;

import jp.terasoluna.fw.batch.core.JobException;

public class SampleException extends JobException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1231604014438236363L;

	public SampleException() {
		super();
	}
	
	public SampleException(String message) {
		super(message);
	}
	
}
