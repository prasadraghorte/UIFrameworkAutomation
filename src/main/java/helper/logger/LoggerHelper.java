package helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class LoggerHelper {
	
	//Initialize Log4j logs
	static Logger Log = Logger.getLogger(LoggerHelper.class);
	
	
	public static void main(String[] args) {
		
		DOMConfigurator.configure("C:\\Users\\prasad.raghorte\\git\\UIFrameworkAutomation\\src\\main\\resources\\configFiles\\logger.xml");
		//PropertyConfigurator.configure("C:\\Users\\prasad.raghorte\\git\\UIFrameworkAutomation\\src\\main\\resources\\configFiles\\log4j.properties");
		Log.info("Logger created successfully");
	}
	 // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

    public static void startTestCase(String sTestCaseName) {

        Log.info("Starting Test case : " + sTestCaseName);
    }

    //This is to print log for the ending of the test case

    public static void endTestCase(String sTestCaseName) {

        Log.info(sTestCaseName+" Test case Finished.");
        Log.info("***************************************************************************************************");
    }

    // Need to create these methods, so that they can be called

    public static void info(String message) {

        Log.info(message);

    }

    public static void warn(String message) {

        Log.warn(message);

    }

    public static void error(String message) {

        Log.error(message);

    }

    public static void fatal(String message) {

        Log.fatal(message);

    }

    public static void debug(String message) {

        Log.debug(message);

    }
}
