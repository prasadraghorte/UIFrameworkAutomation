package helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	private WebDriver driver;
	Logger Log = Logger.getLogger(WaitHelper.class);
	
	//Constructor for initializing driver
	public WaitHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Implicit wait
	public void setImplicitWait (long timeout, TimeUnit unit)
	{
		Log.info("Implicit wait has been set to :"+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
	//MEthod used to setup pageload timeout
	public void setPageLoadTimeout(long timeout, TimeUnit unit)
	{
		Log.info("Trying to set Pageload timeout");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
	}
	/**
	 * Explicit wait
	 * @param timeout
	 * @param pollingEvery
	 * @return
	 */
	private WebDriverWait setExplicitWait (long timeout, int pollingEvery)
	{
		Log.info("Explicit wait has been set for :"+timeout);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.pollingEvery(Duration.ofMillis(pollingEvery));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	//Method for element to be visible
	public void waitForElementVisible(WebElement element,long timeout, int pollingEvery)
	{
		Log.info("Waiting for element to be visible");
		WebDriverWait wait = setExplicitWait(timeout, pollingEvery);
		wait.until(ExpectedConditions.visibilityOf(element));
		Log.info("Element is visible");
	}
	
	//MEthod for Wait till element to be clickable
	public void waitForElementToClickable(WebElement element, long timeout)
	{
		Log.info("Waiting for element to be clickable");
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Log.info("Element is now clickable");
	}
	
	//Method for waiting till element to disappear from screen
	public void waitForNoElement(WebElement element, long timeout)
	{
		Log.info("Waiting for element to disappear");
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOf(element));
		Log.info("Element has disappeared");
	}
	
	//Method for switching to a frame
	public void waitandSwitchtoFrame(WebElement element, long timeout)
	{
		Log.info("Waiting for element to disappear");
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		Log.info("Element has disappeared");
	}
	
	/**
	 * implementing fluent wait
	 */
	private Wait<WebDriver> getFluentWait(int timeOutinSeconds, int pollingTime)
	{
		Log.info("Fluent Wait Initiated till element visibile");
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutinSeconds))
				.pollingEvery(Duration.ofMillis(pollingTime));	
		return fwait;
	}
	
	//Wait for element using fluent wait
	public void waitForElement(WebElement element, int timeouts, int pollingEverySec)
	{
		Wait<WebDriver> fwait = getFluentWait(timeouts, pollingEverySec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		Log.info("Successfully awaited till element visibility");
	}
}
