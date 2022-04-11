package com.mco.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.mco.utility.TestUtill;

//
public class TestBase {
	TestUtill utils;
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/Users/khosruzzaman/FrameWork/MulticartAutomationSuit/src/main/java/"
					+ "com/mco/configurations/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/khosruzzaman/Drivers/chromedriver"); 
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "/Users/khosruzzaman/Drivers/geckodriver");
			driver = new FirefoxDriver();
		}else {
			driver = new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtill.PAGE_LOADE_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICITLY_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	
	
	
	
							
}
