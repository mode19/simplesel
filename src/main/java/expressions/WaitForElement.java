package expressions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.imran.guitester.Context;
import com.imran.guitester.utils.BySplitter;

public class WaitForElement extends AbstractSelectorExpression {

	public WaitForElement( String selector) {
		super( selector );
	}

	@Override
	public void interpretImpl(Context ctx) {
		WebDriverWait wait = new WebDriverWait(ctx.getDriver(), 10);
		
		WebElement el = wait.until( ExpectedConditions.visibilityOfElementLocated(new BySplitter(selector)));
	}


	
}
