package expressions;

import com.imran.guitester.Context;

public class Click extends AbstractSelectorExpression {

	public Click( String selector) {
		super( selector );
	}

	@Override
	public void interpretImpl(Context ctx) {
		
		FindFirstVisible ex = new FindFirstVisible(selector);
		
		ex.interpret(ctx);
	
		if( ex.getResult() != null ) {
			ex.getResult().click();
		} else {
			System.out.println ("No elements found" );
		}
	}

	
}
