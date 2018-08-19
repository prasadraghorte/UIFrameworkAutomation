package Tests;

import org.testng.annotations.Test;

import testBase.testBase;

public class Test1 extends testBase {

	@Test
	public void testScreenshot() {
		driver.get("https://www.seleniumhq.org/");
		captureScreenAndReturnPath("FirstScreen", driver);
	}

}
