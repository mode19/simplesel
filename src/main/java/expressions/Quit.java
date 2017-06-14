package expressions;

import com.imran.guitester.Context;

public class Quit extends AbstractExpression {

	public Quit() {
	}

	@Override
	public void interpretImpl(Context ctx) {
	}

	@Override
	public void afterInterpret(Context ctx) {
		super.afterInterpret(ctx);
		
		ctx.getDriver().quit();
	}

	
}
