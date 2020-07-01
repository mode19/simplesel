package expressions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.imran.guitester.Context;

public class Download extends AbstractSelectorExpression {

	String outputFilename = "";
	String selector = "";
	
	public Download( String selector, String outputFilename) {
		super( selector );
		this.selector = selector;
		this.outputFilename = outputFilename;
	}

	@Override
	public void interpretImpl(Context ctx) {
		
		WebElement ex = ctx.getDriver().findElement(By.xpath(this.selector));
		System.out.println( "exL=" + ex.toString());
		String myUrl = ex.getAttribute("data-href");
		System.out.println( "MYURL=" + myUrl);
		try {
			FileUtils.copyURLToFile(
					  new URL(myUrl), 
					  new File(this.outputFilename), 
					  5000, 
					  5000);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
}
