package com.imran.guitester;

import expressions.AbstractExpression;
import expressions.Block;
import expressions.Click;
import expressions.Quit;
import expressions.SetText;
import expressions.Test;
import expressions.Url;
import expressions.WaitForElement;

public class Parser {

	private Block rootBlock = new Block();
	
	public Parser() {
	}
	
	public void parse( String inputStr ) {
		String[] lines = inputStr.split(System.lineSeparator());

		for( String line : lines ) {
			AbstractExpression expr = null;
			
			String[] params = line.split( "\\|" );
			
			String cmdName = params[0];
			
			if( cmdName.equals( "URL" ) ) {
				expr = new Url( params[1] );
			} else if( cmdName.equals( "CLICK")) {
				expr = new Click( params[1] );
			} else if( cmdName.equals( "WAITFOR")) {
				expr = new WaitForElement( params[1] );
			} else if( cmdName.equals( "SETTEXT")) {
				expr = new SetText( params[1], params[2] );
			} else if( cmdName.equals( "TEST")) {
				expr = new Test( params[1] );
			} else if( cmdName.equals( "QUIT")) {
				expr = new Quit();
			}

			if( expr != null ) {
				rootBlock.addExpression( expr );
			}
			
		}

	}
	
	AbstractExpression getRootBlock() {
		return rootBlock;
	}
	
	
}
