package helper.generic;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import helper.logger.LoggerHelper;

public class elementHelper {
	Logger Log = LoggerHelper.getLogger(elementHelper.class);

	/**
	 * Method used to click on element
	 * @param element
	 * @throws Exception
	 */
	public void clickOnElement(WebElement element) throws Exception
	{
		try
		{
			element.click();
			Log.info("Clicked on element." + element.getText());
		}
		catch(Exception e)
		{
			Log.error("Failed to click on element: " + element.getText());
			throw new Exception("Failed to click on element " +element.getText() +" with error " + e.getMessage());
		}
	}
	
	/**
	 * Method used to send text over a text field
	 * @param element
	 * @param text
	 * @throws Exception
	 */
	public void SendTextOnElement(WebElement element, String text) throws Exception
	{
		try
		{
			element.sendKeys(text);
			Log.info("Entered text on element." + element.getText()+" text :"+text);
		}
		catch(Exception e)
		{
			Log.error("Failed to enter text on element: " + element.getText());
			throw new Exception("Failed to enter text on element " +element.getText() +" with error " + e.getMessage());
		}
	}
}
