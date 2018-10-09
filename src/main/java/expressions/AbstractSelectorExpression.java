package expressions;

import com.imran.guitester.Context;

public abstract class AbstractSelectorExpression extends AbstractExpression {

	String selector;

	public AbstractSelectorExpression( String selector) {
		this.selector = selector;
	}

	@Override
	public void beforeInterpret(Context ctx) {
		//super.beforeInterpret(ctx);
		System.out.println( "beforeInterpret:" + this.getClass().getSimpleName() + ":" + selector );
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

	
}
