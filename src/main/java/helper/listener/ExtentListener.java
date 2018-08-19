package helper.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import helper.logger.LoggerHelper;
import utils.ExtentManager;

public class ExtentListener implements ITestListener {
	org.apache.log4j.Logger log = LoggerHelper.getLogger(ExtentListener.class);
	public static ExtentReports extent;
	public static ExtentTest test;

	public void onTestStart(ITestResult result) {
		//test.log(Status.INFO, result.getName() + " test Started");
	}

	public void onTestSuccess(ITestResult result) {
		//test.log(Status.INFO, result.getName() + " test Passed");
		Reporter.log(result.getMethod().getMethodName() + " test passed");
		log.info(result.getMethod().getMethodName() + " test passed");

	}

	public void onTestFailure(ITestResult result) {
		//test.log(Status.FAIL, result.getThrowable());
		Reporter.log(result.getMethod().getMethodName() + " test Failed");
		log.info(result.getMethod().getMethodName() + " test Failed");

	}

	public void onTestSkipped(ITestResult result) {
		//test.log(Status.SKIP, result.getThrowable());
		Reporter.log(result.getMethod().getMethodName() + " test Skipped");
		log.info(result.getMethod().getMethodName() + " test Skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		//extent = ExtentManager.getInstance();
		//test = extent.createTest(getClass().getName());
		//below line also works good
		//test = extent.createTest(context.getCurrentXmlTest().getName());
		Reporter.log(context.getName() + " test started");
		log.info(context.getName() + " test started");

	}

	public void onFinish(ITestContext context) {
		//extent.flush();
		Reporter.log(context.getName() + " test Finished");
		log.info(context.getName() + " test Finished");

	}

}
