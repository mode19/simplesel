package expressions;

import org.junit.Test;

import com.imran.guitester.Context;
import com.imran.guitester.Parser;

public class AbstractExpressionTest {

	
	@Test
	public void testInterpretValidCommand() throws Exception {
		
		AbstractExpression ae = new Block();
		
		Context ctx = new Context();
		ae.interpret(ctx);
		
		
	}

}
