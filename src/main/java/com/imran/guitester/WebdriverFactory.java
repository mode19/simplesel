package com.imran.guitester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LoggingPreferences;

public class WebdriverFactory {

	/*
	 * Factory method for getting browsers
	 */
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
 
		switch (browserName) {
		case "Firefox":
	        LoggingPreferences logs = new LoggingPreferences();
	        /* 
	        logs.enable(LogType.DRIVER, Level.FINE);
	        logs.enable(LogType.BROWSER, Level.FINE);
	        logs.enable(LogType.CLIENT, Level.FINE);
	        logs.enable(LogType.PROFILER, Level.FINE);
	        logs.enable(LogType.SERVER, Level.FINE);
	        */
	       
	        //System.getProperties().put("webdriver.log.driver", "FINE");
	       
	      /* 
	        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	        //capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
	        WebDriver driver = new FirefoxDriver(capabilities);
	        */
			driver = new FirefoxDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		case "Chrome":
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}
}
