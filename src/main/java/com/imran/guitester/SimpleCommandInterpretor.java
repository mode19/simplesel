package com.imran.guitester;

import java.util.Scanner;

import com.imran.guitester.exceptions.InvalidNumberofParamsForCommandException;
import com.imran.guitester.exceptions.UnknownCommandException;

public class SimpleCommandInterpretor extends AbstractCommandInterpretor {

	private Scanner sc = new Scanner(System.in);
	private Context ctx = null;
	
	public SimpleCommandInterpretor( Context ctx ) {
		this.ctx = ctx;
	}

	public void startCommandLoop() {
		
			while( true ) {
				String cmdString = readNextCommand();
				executeSnippet(ctx, cmdString);
			}
	}
	
	private String readNextCommand() {
		return sc.nextLine();
	}
}
