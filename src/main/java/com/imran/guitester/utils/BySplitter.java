package com.imran.guitester.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class BySplitter extends By {

	private By delegate;
	
	public BySplitter( String searchStr ) {
		if( isXpath( searchStr) ) {
			delegate = new ByXPath( searchStr );
		} else {
			delegate = new ByCssSelector(searchStr );
		}
	}

	private boolean isXpath( String searchStr) {
		return searchStr.startsWith("//") || searchStr.startsWith( "xpath=" ) || searchStr.startsWith("(//");
	}

	@Override
	public WebElement findElement(SearchContext context) {
		return delegate.findElement(context);
	}

	@Override
	public List<WebElement> findElements(SearchContext arg0) {
		return delegate.findElements(arg0);
	}
	

}
