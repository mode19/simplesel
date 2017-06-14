package com.imran.guitester;

import java.io.File;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Main {
		/*
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        driver.quit();
        */	
	public static void main(String[] args) throws Exception {

		String inputStr = FileUtils.readFileToString( new File( "input.txt" ) );

		Parser parser = new Parser();
		parser.parse( inputStr );
	
        LoggingPreferences logs = new LoggingPreferences();
        
        logs.enable(LogType.DRIVER, Level.FINE);
        logs.enable(LogType.BROWSER, Level.FINE);
        logs.enable(LogType.CLIENT, Level.FINE);
        logs.enable(LogType.PROFILER, Level.FINE);
        logs.enable(LogType.SERVER, Level.FINE);
       
        //System.getProperties().put("webdriver.log.driver", "FINE");
       
       
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
        WebDriver driver = new FirefoxDriver(capabilities);
		Context ctx = new Context();
		ctx.setDriver( driver );
	
		parser.getRootBlock().interpret( ctx );
		
	}

}
