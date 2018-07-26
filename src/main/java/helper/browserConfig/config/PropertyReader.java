package helper.browserConfig.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import helper.browserConfig.BrowserType;
import resources.resourcesHelper;

public class PropertyReader implements ConfigReader {
	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {
		String path = resourcesHelper.getResourcePath("src\\main\\resources\\configFiles\\config.properties");
		try {
			file = new FileInputStream(new File(path));
			OR = new Properties();
			OR.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getImpliciteWait() {
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTimeout() {
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public BrowserType GetBrowserType() {
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

}
