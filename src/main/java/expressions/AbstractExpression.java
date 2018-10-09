package expressions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.imran.guitester.Context;

public abstract class AbstractExpression {

	public void beforeInterpret( Context ctx )
	{
		System.out.println( "beforeInterpret:" + this.getClass().getSimpleName() );
	}

	public abstract void interpretImpl( Context ctx );

	public void interpret( Context ctx )
	{
		beforeInterpret( ctx );

		interpretImpl( ctx );

		afterInterpret( ctx );
	}

	public static boolean hasQuit(WebDriver driver) {
		if( driver != null ) {
			return ((RemoteWebDriver)driver).getSessionId() == null;
		} else {
			return true;
		}
	}
	
	public void afterInterpret( Context ctx )
	{
		int c = ctx.incCounter();
	
		if( !hasQuit(ctx.getDriver()) ) {
			File scrFile = ((TakesScreenshot)ctx.getDriver()).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			try {
				FileUtils.copyFile(scrFile, new File("screenshot" + c + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
