package com.imran.guitester;

import java.io.File;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Main {

	public static void main(String[] args) throws Exception {

		if( args.length != 1 ) {
			System.out.println( "usage: guitester <inputscript.txt>");
			System.exit(-1);
		}
		
		String inputScriptFileName = args[0];

		String inputStr = FileUtils.readFileToString( new File( inputScriptFileName ) );
        WebDriver driver = WebdriverFactory.getBrowser("Firefox" );
        
		Context ctx = new Context();
		ctx.setDriver( driver );

		
		//SimpleCommandInterpretor cmd = new SimpleCommandInterpretor(ctx);
		JLineCommandInterpretor cmd = new JLineCommandInterpretor(ctx);
		
		cmd.init();
		
		cmd.executeScript(inputStr);
		
		cmd.startCommandLoop();
	}

}
