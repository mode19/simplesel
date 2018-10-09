package com.imran.guitester;

import com.imran.guitester.exceptions.InvalidNumberofParamsForCommandException;
import com.imran.guitester.exceptions.UnknownCommandException;

import expressions.AbstractExpression;
import expressions.Block;
import expressions.Click;
import expressions.FindElements;
import expressions.FindFirstVisible;
import expressions.FindXPath;
import expressions.Help;
import expressions.QueryAttributes;
import expressions.Quit;
import expressions.Select;
import expressions.SetText;
import expressions.Test;
import expressions.Url;
import expressions.WaitForElement;

public class Parser {

	private Block rootBlock = new Block();
	
	public Parser() {
	}

	public AbstractExpression getRootBlock() {
		return rootBlock;
	}
	
	public void parse( String inputStr ) throws UnknownCommandException, InvalidNumberofParamsForCommandException {
		String[] lines = inputStr.split(System.lineSeparator());

		for( String line : lines ) {
			AbstractExpression expr = null;
			
			String[] params = line.split( "\\|" );
			
			String cmdName = params[0];
		
			if( cmdName == null || cmdName.equals( "" ) ) {
				continue;
			}

			if( cmdName.equalsIgnoreCase( "URL" ) ) {
				expr = new Url( params[1] );
			} else if( cmdName.equalsIgnoreCase( "CLICK")) {
				expectParams( params, 2 );
				expr = new Click( params[1] );
			} else if( cmdName.equalsIgnoreCase( "WAITFOR")) {
				expectParams( params, 2 );
				expr = new WaitForElement( params[1] );
			} else if( cmdName.equalsIgnoreCase( "SETTEXT")) {
				expectParams( params, 3);
				expr = new SetText( params[1], params[2] );
			} else if( cmdName.equalsIgnoreCase( "TEST")) {
				expectParams( params, 2);
				expr = new Test( params[1] );
			} else if( cmdName.equalsIgnoreCase( "QUIT")) {
				expectParams( params, 1);
				expr = new Quit();
			} else if( cmdName.equalsIgnoreCase( "HELP")) {
				expectParams( params, 1);
				expr = new Help();
			} else if( cmdName.equalsIgnoreCase( "FINDELEMENTS")) {
				expectParams( params, 1);
				expr = new FindElements();
			} else if( cmdName.equalsIgnoreCase( "FINDFIRSTVISIBLE")) {
				expectParams( params, 2);
				expr = new FindFirstVisible(params[1]);
			} else if( cmdName.equalsIgnoreCase( "QUERYATTRIBUTE")) {
				expectParams( params, 3);
				expr = new QueryAttributes(params[1], params[2]);
			} else if( cmdName.equalsIgnoreCase( "FINDXPATH")) {
				expectParams( params, 2);
				expr = new FindXPath(params[1]);
			} else if( cmdName.equalsIgnoreCase( "SELECT")) {
				expectParams( params, 4);
				expr = new Select(params[1], params[2], params[3]);
			} else if( cmdName.equalsIgnoreCase( "EXIT")) {
				System.exit(0);
			} else {
				throw new UnknownCommandException( cmdName );
			}

			if( expr != null ) {
				rootBlock.addExpression( expr );
			}
			
		}

	}

	private static void expectParams( String[] params, int sizeExpected ) throws InvalidNumberofParamsForCommandException {
		if( params == null || params.length != sizeExpected ) {
			throw new InvalidNumberofParamsForCommandException();
		}
	}

	
	
}
