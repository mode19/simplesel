package expressions;

import com.imran.guitester.Context;

public class Select extends AbstractSelectorExpression {

	private enum SelectionType { BYNAME, BYINDEX, BYTEXT };

	private String selectionType;
	private String selectionValue;

	public Select( String selector, String selectionType, String selectionValue) {
		super( selector );
		this.selectionType = selectionType;
		this.selectionValue = selectionValue;
	}

	@Override
	public void interpretImpl(Context ctx) {
		
		FindFirstVisible ex = new FindFirstVisible(selector);
		
		ex.interpret(ctx);
	
		if( ex.getResult() != null ) {
			org.openqa.selenium.support.ui.Select el = new org.openqa.selenium.support.ui.Select(ex.getResult());
			
			
			if( selectionType.equalsIgnoreCase(SelectionType.BYINDEX.toString()))
			{
				el.selectByIndex( Integer.valueOf( selectionValue ));
			} 
			else if( selectionType.equalsIgnoreCase(SelectionType.BYNAME.toString()))
			{
				el.selectByValue( selectionValue);
			} 
			else if( selectionType.equalsIgnoreCase(SelectionType.BYTEXT.toString()))
			{
				el.selectByVisibleText(selectionValue);
			}

		} else {
			System.out.println ("No elements found" );
		}
	}


	
}
