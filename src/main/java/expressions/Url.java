package expressions;

import java.util.Arrays;
import java.util.List;

import com.imran.guitester.Context;

public class Url extends AbstractExpression {

	private String url  = "";
	
	public Url( String url) {
		this.url = url;
	}

	@Override
	public void interpretImpl(Context ctx) {
		ctx.getDriver().get( url );
	}



	
}
