package com.imran.guitester;

import org.openqa.selenium.WebDriver;

public class Context {

	WebDriver driver = null;
	int counter = 0;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public int incCounter() {
		counter += 1;
		return counter;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
	
	
}
