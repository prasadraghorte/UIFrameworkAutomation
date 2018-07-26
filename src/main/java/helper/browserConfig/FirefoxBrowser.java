package helper.browserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import resources.resourcesHelper;

public class FirefoxBrowser {

	/**
	 * Method to initialize desired capabilities for firefox browser
	 * @return
	 */
	public FirefoxOptions getFirefoxOptions()
	{
		DesiredCapabilities firefoxcap = DesiredCapabilities.firefox();
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		
		firefoxcap.setCapability(FirefoxDriver.PROFILE, profile);
		firefoxcap.setCapability("marionette", true);
		
		FirefoxOptions options = new FirefoxOptions(firefoxcap);
		return options;
	}
	
	public WebDriver getFirefoxDriver(FirefoxOptions options)
	{
		if(System.getProperty("os.name").contains("Mac"))
		{
			System.setProperty("webdriver.gecko.driver", resourcesHelper.getResourcePath(""));
		}
		else if(System.getProperty("os.name").contains("Window"))
		{
			System.setProperty("webdriver.gecko.driver", resourcesHelper.getResourcePath(""));
		}
		return null;
	}
}
