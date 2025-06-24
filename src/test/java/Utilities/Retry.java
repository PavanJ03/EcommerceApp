package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int retryCount = 0;
	int maxCount = 3 ;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(!(result.isSuccess())) {
			if(retryCount<maxCount) {
				retryCount++;
				result.setStatus(result.FAILURE);
				return true;
				
			}
		}
		else {
			result.setStatus(result.SUCCESS);
		}
		
		return false;
	}

}
