package com.imran.guitester;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebdriverFactory {

	/*
	 * Factory method for getting browsers
	 */
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
 
		switch (browserName) {
		case "Firefox":
	        LoggingPreferences logs = new LoggingPreferences();
	        //FirefoxProfile profile = new FirefoxProfile();
	        //profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
	        //profile.setPreference("browser.download.folderList", 2);
	        //profile.setPreference("browser.download.dir", '.');
	        ProfilesIni profileIni = new ProfilesIni();
	        FirefoxProfile profile = profileIni.getProfile("default");

	        String mimeTypes = "application/pdf";
	        //profile.setPreference("browser.preferences.instantApply",true);
	        //profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain, application/octet-stream, application/binary, text/csv, application/csv, application/excel, text/comma-separated-values, text/xml, application/xml, application/pdf");
	        //profile.setPreference("browser.helperApps.alwaysAsk.force",false);
	        //profile.setPreference("browser.download.manager.showWhenStarting",false);
	        //profile.setPreference("browser.download.folderList",0);

	        profile.setPreference("browser.download.folderList", 2);
	        profile.setPreference("browser.download.manager.showWhenStarting", false);
	        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
	        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", mimeTypes);
	        profile.setPreference("browser.download.manager.focusWhenStarting",false);
	        profile.setPreference("browser.download.manager.useWindow", false);
	        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
	        FirefoxOptions options = new FirefoxOptions();
	        options.setProfile(profile);
	        //System.getProperties().put("webdriver.log.driver", "FINE");

	        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	        //capabilities.set
	        //capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
	        //driver = new FirefoxDriver(capabilities);
	        //driver = new FirefoxDriver( new FirefoxOptions() );
	        //capabilities.setCapability(FirefoxDriver.PROFILE, profile);

			try {
				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//driver = new FirefoxDriver();
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
