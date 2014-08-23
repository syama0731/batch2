package sample.BL0001;

import java.util.ArrayList;
import java.util.List;

import jp.terasoluna.fw.batch.openapi.BLogicResult;
import jp.terasoluna.fw.batch.openapi.ReturnCode;
import jp.terasoluna.fw.batch.openapi.SupportLogic;
import jp.terasoluna.fw.file.util.FileUtility;

public class BL0001PreBLogic implements SupportLogic<BL0001JobContext> {

	@Override
	public BLogicResult execute(BL0001JobContext jobContext) {
		
		String basepath = "/Users/sin/git/batch2/terasoluna-batch-blank/";
		
		List<String> fileList = new ArrayList<String>();
		
		fileList.add(basepath + "/input/BL0001Input1.csv");
		fileList.add(basepath + "/input/BL0001Input2.csv");
		
		FileUtility.mergeFile(fileList, basepath + "/input/BL0001Input.csv");
		
		System.out.println("start BL0001");
		
		return new BLogicResult(ReturnCode.NORMAL_CONTINUE);
	}

}
