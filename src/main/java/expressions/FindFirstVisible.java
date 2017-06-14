package expressions;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.imran.guitester.Context;
import com.imran.guitester.utils.BySplitter;

public class FindFirstVisible extends AbstractSelectorExpression {

	WebElement result = null;;
	
	public FindFirstVisible( String selector) {
		super( selector );
	}

	@Override
	public void interpretImpl(Context ctx) {
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
