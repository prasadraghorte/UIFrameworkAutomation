package helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javascriptHelper {
	WebDriver driver;
	Logger Log = Logger.getLogger(javascriptHelper.class);
	
	public javascriptHelper(WebDriver driver) 
	{
		this.driver = driver;
	}

	//ExecuteScript method with single arg
	private Object executeScript(String script)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	//ExecuteScript menthod with multiple args
	private Object executeScript(String script, Object...args)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script, args);
	}
	
	public void scrollToElement(WebElement element)
	{
		Log.info("Trying to scroll to an element");
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,element.getLocation().y);
	}
	
	public void scrollToElementAndClick(WebElement element)
	{
		Log.info("Trying to scroll to an element and click on it");
		scrollToElement(element);
		element.click();
	}
	
	public void scrollIntoView(WebElement element)
	{
		executeScript("arguments[0].scrollIntoView(true);", element);
		Log.info("Scrolled to an element.");
	}
	
	public void scrollIntoViewandClick(WebElement element)
	{
		Log.info("Scrolling to an object and clicking on it");
		scrollIntoView(element);
		element.click();
	}
	
	public void scrollDownEnd()
	{
		Log.info("Scroll down till end of page");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollUp()
	{
		Log.info("Scrolling up....");
		executeScript("window.scrollTo(0,-document.body.scollHeight)");
	}
	
	public void ClickUsingJavaScript(WebElement element)
	{
		Log.info("Clicking on element using Javascript");
		executeScript("argument[0].click();",element);
	}
	
}
