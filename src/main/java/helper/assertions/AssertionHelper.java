package helper.assertions;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.Assert;

import helper.logger.LoggerHelper;

public class AssertionHelper {
	private static Logger Log = LoggerHelper.getLogger(AssertionHelper.class);
	
	public static void verifyText(String s1, String s2)
	{
		Log.info("Verifying text "+s1 +" with " +s2);
		Assert.assertEquals(s1, s2);
	}
	
	public static void makeTrue()
	{
		Log.info("Making test Pass");
		Assert.assertTrue(true);
	}
	
	public static void makeTrue(String message)
	{
		Log.info("Making Test Pass");
		Assert.assertTrue(true, message);
	}
	
	public static void makeFalse()
	{
		Log.info("Making test Fail");
		Assert.assertFalse(false);
	}
	
	public static void makeFalse(String message)
	{
		Log.info("Making Test Fail");
		Assert.assertFalse(false, message);
	}
	
	public static void verifyTrue(boolean status)
	{
		Log.info("Verifying status is true");
		Assert.assertTrue(status);
	}
	
	public static void verifyFalse(boolean status)
	{
		Log.info("Verifying status is false");
		Assert.assertFalse(status);
	}
}
