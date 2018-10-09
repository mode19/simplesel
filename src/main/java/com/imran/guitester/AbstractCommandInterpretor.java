package com.imran.guitester;

import com.imran.guitester.exceptions.InvalidNumberofParamsForCommandException;
import com.imran.guitester.exceptions.UnknownCommandException;

public class AbstractCommandInterpretor implements CommandInterpretorInterface {

	protected void executeSnippet(Context ctx, String codeString) {
		try {
			com.imran.guitester.Parser parser = new com.imran.guitester.Parser();
			parser.parse(codeString);
			parser.getRootBlock().interpret( ctx );
		} catch (UnknownCommandException | InvalidNumberofParamsForCommandException e) {
			e.printStackTrace();
		} catch (Exception unknownException ) {
			unknownException.printStackTrace();
		}
	}
}
