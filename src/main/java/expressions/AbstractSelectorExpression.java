package expressions;

import com.imran.guitester.Context;

public abstract class AbstractSelectorExpression extends AbstractExpression {

	String selector;
	
	public AbstractSelectorExpression( String selector) {
		this.selector = selector;
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

	
}
