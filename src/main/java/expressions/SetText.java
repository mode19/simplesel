package expressions;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.imran.guitester.Context;
import com.imran.guitester.utils.BySplitter;

public class SetText extends AbstractExpression {

	private String selector  = "";
	private String textValue = "";
	
	public SetText( String selector, String textValue) {
		this.selector = selector;
		this.textValue = textValue;
	}

	@Override
	public void interpretImpl(Context ctx) {
		FindFirstVisible ex = new FindFirstVisible(selector);
		
		ex.interpret(ctx);
	
		if( ex.getResult() != null ) {
			ex.getResult().clear();
			ex.getResult().sendKeys( textValue );
		} else {
			System.out.println ("No elements found" );
		}
	}

	
}
