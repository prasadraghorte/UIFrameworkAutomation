package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String FileName)
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(FileName);
		reporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		reporter.config().setChartVisibilityOnOpen(true);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setEncoding("utf-8");
		reporter.config().setReportName("Automation Result");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			return createInstance("test-output/extent.html");
		}
		else
		{
			return extent;
		}
	}

}
