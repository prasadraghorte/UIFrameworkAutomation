package helper.browserConfig.config;

import helper.browserConfig.BrowserType;

/**
 * Why we created this Interface?/
 * Ans:Sometime in our framework,certain configuration should be fixed.
 * or certain configuration implementation should be there.
 * If not then yu might end up with missing data.
 * In such scenario of waits they are mandatory part of framework hence 
 * make it interface and write implementation in properttReader.
 * @author prasad.raghorte
 *
 */
public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int getPageLoadTimeout();
	public BrowserType GetBrowserType();

}
