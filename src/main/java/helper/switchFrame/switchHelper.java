package helper.switchFrame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.wait.WaitHelper;

public class switchHelper {
	WebDriver driver;
	Logger Log = Logger.getLogger(WaitHelper.class);
	
	//Constructor
	public switchHelper(WebDriver driver)
	{
		this.driver = driver;
	}

	//Switching to frame using index
	public void switchToFrameIndex(int frameIndex)
	{
		Log.info("Trying to switvh to frame with index " + frameIndex);
		driver.switchTo().frame(frameIndex);
	}
	
	//Method for switching to frame with name
	public void switchToFrameName(String FrameName)
	{
		Log.info("Trying to switch to frame with name " + FrameName);
		driver.switchTo().frame(FrameName);
	}
	
	//Method for switching to frame with locator
	public void switchToFrame(WebElement element)
	{
		Log.info("Trying to switch to frame");
		driver.switchTo().frame(element);
	}
}
