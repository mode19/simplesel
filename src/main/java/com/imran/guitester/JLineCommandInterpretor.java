package com.imran.guitester;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.AttributedString;

import org.jline.builtins.InputRC;
import org.jline.reader.Completer;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.MaskingCallback;
import org.jline.reader.Parser;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import com.imran.guitester.exceptions.InvalidNumberofParamsForCommandException;
import com.imran.guitester.exceptions.UnknownCommandException;

public class JLineCommandInterpretor extends AbstractCommandInterpretor {

	private Context ctx = null;
	private LineReader reader = null;
	private Terminal terminal = null;
	private String prompt = ">>";
	private String rightPrompt = null;
	
	public JLineCommandInterpretor( Context ctx ) {
		this.ctx = ctx;
	}

	public void init() throws IOException {
		TerminalBuilder builder = TerminalBuilder.builder();

        Completer completer = null;
        Parser parser = null;
		
        terminal = builder.build();

        reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(completer)
                .parser(parser)
                .build();

        try {
			InputRC.configure(reader, new File( "configfile").toURI().toURL() );
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}		
        
        
	}

	public void executeScript( String scriptCode) {
		String[] lines = scriptCode.split( System.lineSeparator() );

		for( String scriptLine : lines )
		{
			reader.getHistory().add( scriptLine );
			executeSnippet( ctx, scriptLine );
		}
	}

	public void startCommandLoop() {

	 	while (true) {
            String line = null;
            try {
                line = readNextCommand();
            } catch (UserInterruptException e) {
                // Ignore
            } catch (EndOfFileException e) {
                return;
            }
            if (line == null) {
                continue;
            }

            line = line.trim();

            executeSnippet( ctx, line );
            //terminal.writer().println("======>\"" + line + "\"");
            terminal.flush();	
	 	}
	}



	private String readNextCommand() {
		return reader.readLine(prompt, rightPrompt, (MaskingCallback) null, null);
	}
}
