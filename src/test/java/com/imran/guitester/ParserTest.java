package com.imran.guitester;

import org.junit.Test;

import com.imran.guitester.exceptions.InvalidNumberofParamsForCommandException;
import com.imran.guitester.exceptions.UnknownCommandException;

public class ParserTest {

	@Test(expected=UnknownCommandException.class)
	public void testParseUnknownCommand() throws Exception {
		Parser parser = new Parser();
		
		parser.parse("UNKNOWN_COMMAND");
	}
	
	@Test(expected=InvalidNumberofParamsForCommandException.class)
	public void testParseCommandWithInvalidNumOfParams() throws Exception {
		Parser parser = new Parser();
		
		parser.parse("CLICK");
	}
	
	@Test
	public void testParseValidCommand() throws Exception {
		Parser parser = new Parser();
		parser.parse("CLICK|http://clickme.com");
	}



}
