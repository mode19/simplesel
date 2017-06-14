package expressions;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.imran.guitester.Context;
import com.imran.guitester.utils.BySplitter;

public class Test extends AbstractExpression {

	private String selector  = "";
	
	public Test( String selector) {
		this.selector = selector;
	}

	@Override
	public void interpretImpl(Context ctx) {
		System.out.println( "TEST: " + selector );
		System.out.println( "________________________________________________________________________________");
		List<WebElement> list = ctx.getDriver().findElements( new BySplitter( selector ));
	
		if( list != null ) {
			System.out.println( "Returned " + list.size() + " elements" );
			for( WebElement e : list ) {
				System.out.println( "................................................................................" );
				System.out.println( " * el=" + e.toString() );
				System.out.println( " * id=" + e.getAttribute( "id") );
				System.out.println( " * name=" + e.getAttribute( "name") );
				System.out.println( " * tagname=" + e.getTagName() );
				System.out.println( " * text=" + e.getText() );
				System.out.println( " * isDisplayed=" + e.isDisplayed() );
				System.out.println( " * isEnabled=" + e.isEnabled() );
				System.out.println( " * isSelected=" + e.isSelected() );
				System.out.println( " * attribute[placeholder]=" + e.getAttribute("placeholder") );
				System.out.println( " * attribute[text]=" + e.getAttribute("text") );
				System.out.println( " * attribute[value]=" + e.getAttribute("value") );
			}
		} else {
			System.out.println( "No elements (null) returned" );
		}
		
	}

	
}
