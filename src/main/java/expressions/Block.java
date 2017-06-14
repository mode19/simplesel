package expressions;

import java.util.ArrayList;
import java.util.List;

import com.imran.guitester.Context;

public class Block extends AbstractExpression {

	private List<AbstractExpression> list = new ArrayList<AbstractExpression>();

	public Block() {
	}
	
	public void addExpression( AbstractExpression expression ) {
		list.add( expression );
	}

	@Override
	public void interpretImpl(Context ctx) {
		
		for( AbstractExpression e : list )
		{
			e.interpret( ctx );
		}
	}

	
}
