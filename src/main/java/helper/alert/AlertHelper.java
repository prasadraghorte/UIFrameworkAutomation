package helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import helper.logger.LoggerHelper;

public class AlertHelper {
	WebDriver driver;
	Logger Log = LoggerHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private Alert getAlert()
	{
		Log.info("Switching to alert : "+ driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public String getAlertText()
	{
		Log.info("Trying to get the text of alert");
		return getAlert().getText();
	}
	
	public boolean isAlertPresent()
	{
		try {
			Log.info("Switching to alert : "+ driver.switchTo().alert().getText());
			getAlert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			Log.error(e.getCause());
			return false;
		}
	}
	
	public void acceptAlert()
	{
		getAlert().accept();
		Log.info("Accepted the alert");
	}
	
	public void dismissAlert()
	{
		getAlert().dismiss();
		Log.info("Alert dismissed");
	}
	
	public void acceptAlertIfPresent()
	{
		if(isAlertPresent())
		{
			acceptAlert();
		}
		else
		{
			Log.info("Alert is not present.");
		}
	}
	
	public void dismissAlertIfPresent()
	{
		if(isAlertPresent())
		{
			dismissAlert();
		}
		else
		{
			Log.info("Alert is not present");
		}
	}
	
	public void enterTextOnAlertAndAccept(String text)
	{
		if(isAlertPresent())
		{
			getAlert().sendKeys(text);
			getAlert().accept();
		}
		else
		{
			Log.info("Alert is not present.");
		}
	}
}
