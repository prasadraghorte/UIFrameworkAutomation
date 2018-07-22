package helper.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import helper.logger.LoggerHelper;

public class RetryHelper implements IRetryAnalyzer{
	private int retryCount = 0;
	private int MaxRetryCount = 3;
	Logger Log = LoggerHelper.getLogger(RetryHelper.class);
	
	
	public boolean retry(ITestResult result) {
		if(retryCount < MaxRetryCount)
		{
			Log.info("Retrying Test "+result.getName()+" with status "+ getResultStatus(result.getStatus()) +"for the "+(retryCount+1)+" times");
			retryCount++;
			return true;
		}
		return false;
	}

	private String getResultStatus(int status)
	{
		String resultstatus = null;
		if(status == 1)
			resultstatus = "Success";
		if(status == 2)
			resultstatus = "Failure";
		if(status == 3)
			resultstatus = "Skip";
		return resultstatus;
	}
}
