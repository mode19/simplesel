package expressions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.imran.guitester.Context;
import com.imran.guitester.utils.BySplitter;

public class FindFirstVisible extends AbstractSelectorExpression {

	WebElement result = null;;
	
	public FindFirstVisible( String selector) {
		super( selector );
	}

	@Override
	public void interpretImpl(Context ctx) {
		
		//WebDriverWait wait = new WebDriverWait( ctx.getDriver(), 5000);
		
		//wait.until( ExpectedConditions.elementToBeClickable( new BySplitter(selector)));
		
		List<WebElement> list = ctx.getDriver().findElements( new BySplitter(selector) );

		if( list != null ) {
			for( WebElement e : list ) {
				if( e.isDisplayed() ) {
					result = e;
					return;
				}
			}
		}
	}

	public WebElement getResult() {
		return result;
	}

	public void setResult(WebElement result) {
		this.result = result;
	}

	

	
}
