package helper.assertions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.logger.LoggerHelper;

public class VerificationHelper {
	
	WebDriver driver;
	Logger Log = LoggerHelper.getLogger(VerificationHelper.class);
	
	public VerificationHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * Verification for element to be displayed
	 */
	public boolean isElementDisplayed(WebElement element)
	{
		try 
		{
			element.isDisplayed();
			Log.info("Element is displayed.");
			return true;
		}
		catch(Exception e)
		{
			Log.error("Element not displayed");
			return false;
		}
	}
	
	/**
	 * Method used to determine whether an element is selected or not.
	 * @param element
	 * @return
	 */
	public boolean isElementSelected(WebElement element)
	{
		try 
		{
			element.isSelected();
			Log.info("Element is selected.");
			return true;
		}
		catch(Exception e)
		{
			Log.error("Element not selected");
			return false;
		}
	}
	
	/**
	 * This method is used to determine whether an element is enabled or not
	 * @param element
	 * @return
	 */
	public boolean isElementEnabled(WebElement element)
	{
		try 
		{
			element.isEnabled();
			element.getText();
			Log.info("Element is enabled.");
			return true;
		}
		catch(Exception e)
		{
			Log.error("Element not enabled");
			return false;
		}
	}
	
	public String getTextOfElement(WebElement element)
	{
		if(element == null)
		{
			Log.info("Element is null");
			return null;
		}
		isElementDisplayed(element);
		String name = element.getText();
		return name;	
	}
}
