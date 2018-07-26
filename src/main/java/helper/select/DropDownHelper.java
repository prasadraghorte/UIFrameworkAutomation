package helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helper.logger.LoggerHelper;

public class DropDownHelper {

	WebDriver driver;
	Logger Log = LoggerHelper.getLogger(DropDownHelper.class);
	
	public DropDownHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void selectUsingIndex(WebElement element, int index)
	{
		try {
		Select select = new Select(element);
		select.selectByIndex(index);
		Log.info("Element selected from dropdown with index " + index);
		}
		catch(Exception e)
		{
			Log.error("Failed to select element with index " +index);
		}
	}
	
	public void selectUsingValue(WebElement element, String value)
	{
		try 
		{
			Select select = new Select(element);
			select.selectByValue(value);
			Log.info("Element selected from dropdown with value " + value);
		}
		catch(Exception e)
		{
			Log.error("Failed to select element with value " +value);
		}
	}
	
	public void selectUsingVisibleText(WebElement element, String visibleText)
	{
		try 
		{
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
			Log.info("Element selected from dropdown with text " + visibleText);
		}
		catch(Exception e)
		{
			Log.error("Failed to select element with text " +visibleText);
		}
	}
	
	public void deSelectUsingIndex(WebElement element, int index)
	{
		try {
		Select select = new Select(element);
		select.deselectByIndex(index);
		Log.info("Element deselected from dropdown with index " + index);
		}
		catch(Exception e)
		{
			Log.error("Failed to deselect element with index " +index);
		}
	}
	
	public void deSelectUsingValue(WebElement element, String value)
	{
		try 
		{
			Select select = new Select(element);
			select.deselectByValue(value);
			Log.info("Element deselected from dropdown with value " + value);
		}
		catch(Exception e)
		{
			Log.error("Failed to deselect element with value " +value);
		}
	}
	
	public void deSelectUsingVisibleText(WebElement element, String visibleText)
	{
		try 
		{
			Select select = new Select(element);
			select.deselectByVisibleText(visibleText);
			Log.info("Element deselected from dropdown with text " + visibleText);
		}
		catch(Exception e)
		{
			Log.error("Failed to deselect element with text " +visibleText);
		}
	}
	
	public List<String> getAllOptionsOfDropdown(WebElement element)
	{
		Log.info("Trying to get All the options from dropdown.");
		Select select = new Select(element);
		List<WebElement> dropdownOptions = select.getOptions();
		List<String> elementList = new LinkedList<String>();
		for(WebElement ele:dropdownOptions)
		{
			String text = ele.getText();
			elementList.add(text);
			Log.info("Added element "+text+ " to the element List");
		}
		return elementList;
	}
}
