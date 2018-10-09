package expressions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.imran.guitester.Context;
import com.imran.guitester.utils.BySplitter;

public class FindElements extends AbstractExpression {

	WebElement result = null;;
	
	public FindElements() {
		super();
	}

	@Override
	public void interpretImpl(Context ctx) {
		List<WebElement> list = ctx.getDriver().findElements( new BySplitter("//input") );

		if( list != null ) {
			for( WebElement e : list ) {
				if( e.isDisplayed() ) {
					System.out.println( e.toString());
				}
			}
		}
	}

}
