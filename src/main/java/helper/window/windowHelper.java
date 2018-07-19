package helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class windowHelper {
	WebDriver driver;
	Logger Log = Logger.getLogger(windowHelper.class);
	
	public windowHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//This method is used to switch to parent window
	public void switchTOParentWindow()
	{
		Log.info("Trying to switch to parent window");
		driver.switchTo().defaultContent();
	}
	
	public void switchToWindow(int index)
	{
		Set<String> windows = driver.getWindowHandles();
		int i =1;
		for(String window : windows)
		{
			if(i==index)
			{
				driver.switchTo().window(window);
			}
			else
				i++;
		}
	}
	
	public void closeAllTabsAndSwitchTMainWindow()
	{
		Set<String> windows = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();
		for(String window : windows)
		{
			if(!window.equalsIgnoreCase(mainWindow))
				driver.close();
		}
	}
}
