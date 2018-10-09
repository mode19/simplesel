package expressions;

import java.util.HashMap;
import java.util.Map;

import com.imran.guitester.Context;

public class Help extends AbstractExpression {


	public Help() {
	}

	@Override
	public void interpretImpl(Context ctx) {
		System.out.println( "____________________________________________________________________________________________________" );
		System.out.println( "" );
		System.out.println( "BLOCK 	- defines a sequence of commands" );
		System.out.println( "CLICK|selector - click on element located by 'selector'" );
		System.out.println( "URL|url 	- go to webpage located at 'url'" );
		System.out.println( "HELP		- show help messages" );
		System.out.println( "____________________________________________________________________________________________________" );
		try {
			Thread.currentThread().sleep( 1000 );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	@Override
	public void afterInterpret(Context ctx) {
		super.afterInterpret(ctx);
	}

	
}
