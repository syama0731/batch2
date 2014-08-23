package sample.exception;

import jp.terasoluna.fw.batch.core.JobException;
import jp.terasoluna.fw.batch.core.JobExceptionHandler;
import jp.terasoluna.fw.batch.core.JobStatus;
import jp.terasoluna.fw.batch.openapi.JobContext;

public class SampleExceptionHandler implements JobExceptionHandler {

	@Override
	public void handlException(JobContext jobContext,
			JobException jobException, JobStatus jobStatus) {
		
		System.out.println(jobException.getMessage());

	}

}
