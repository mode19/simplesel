package expressions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.imran.guitester.Context;
import com.imran.guitester.utils.BySplitter;

public class QueryAttributes extends AbstractExpression {

	private String selector = "";
	private String attributeName = "";

	public QueryAttributes(String selector, String attributeName) {
		super();
		this.selector = selector;
		this.attributeName = attributeName;
	}

	@Override
	public void interpretImpl(Context ctx) {
		List<WebElement> list = ctx.getDriver().findElements( new BySplitter(selector) );

		if( list != null ) {
			for( WebElement e : list ) {
				if( e.isDisplayed() ) {
					System.out.println( e.getTagName() + ",id=" + e.getAttribute("id") + ",text=" + e.getText() + "," + attributeName + "=" + e.getAttribute(attributeName));
				}
			}
		}
	}

}
