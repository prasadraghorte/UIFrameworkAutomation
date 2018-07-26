package helper.browserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import resources.resourcesHelper;

public class ChromeBrowser {
	/**
	 * Method to initialize desired capabilities for Chrome browser
	 * @return
	 */
	public ChromeOptions getChromeOptions()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		options.addArguments("--disable-popup-blocking");
		
		DesiredCapabilities chromeCap = DesiredCapabilities.chrome();
		chromeCap.setJavascriptEnabled(true);
		
		options.setCapability(ChromeOptions.CAPABILITY, chromeCap);
		
		return options;
	}
	
	/**
	 * this method is used to set properties and path for chromeBrowser
	 * @param chromeOptions
	 * @return
	 */
	public WebDriver getChromeDriver(ChromeOptions chromeOptions)
	{
		if(System.getProperty("os.name").contains("Mac"))
		{
			System.setProperty("webdriver.chrome.driver", resourcesHelper.getResourcePath(""));
		}
		else if(System.getProperty("os.name").contains("Window"))
		{
			System.setProperty("webdriver.chrome.driver", resourcesHelper.getResourcePath(""));
		}
		return null;
	}

}
