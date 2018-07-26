package helper.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.testng.TimeBombSkipException;

import helper.logger.LoggerHelper;

public class ExcelHelper {
	Logger Log = LoggerHelper.getLogger(ExcelHelper.class);
	
	/**
	 * @throws Exception 
	 * Method to update result of test execution in excel sheet
	 * @throws 
	 */
	
	public void UpdateResultInExcel(String excelLocation, String sheetName, String testCaseName, String Status) throws Exception 
	{
		try
		{
			//We will create an object of FileInputStream class
			//can also try new FileInputStream(new File(path)) if below ddnt work
			FileInputStream fis = new FileInputStream(excelLocation);
			//Now we will create an object of XSSFWorkbook
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			//Now we will initialize sheet using this workbook instance
			XSSFSheet sheet = workbook.getSheet(sheetName);
			//Getting row count
			int rowCount = sheet.getLastRowNum()+1;
			for(int i=1;i<rowCount;i++)
			{
				XSSFRow row = sheet.getRow(i);
				String value = row.getCell(0).getStringCellValue();
				if(value.contains(testCaseName))
				{
					row.createCell(1).setCellValue(Status);
					fis.close();
					Log.info("Test results updated");
					FileOutputStream output = new FileOutputStream(excelLocation);
					workbook.write(output);
					output.close();
					break;
				}
			}
		}
		catch(Exception e)
		{
			Log.error(e.getMessage());
			throw new Exception("Failed to update result in excel File");
		}
		
	}
	
	//Yet to be implemented Scratch Code
	public void getExcelData(String excelLocation, String sheetName) throws IOException
	{
		try {
			FileInputStream fis = new FileInputStream(excelLocation);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int sheetIndex = workbook.getSheetIndex(sheetName);
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			
			sheet.getLastRowNum();
			sheet.getRow(0).getLastCellNum();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
