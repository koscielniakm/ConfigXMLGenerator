package cxg.console.elements;

import java.util.ArrayList;
import java.util.List;

import cxg.console.io.ConsoleReader;
import cxg.console.io.ConsoleWriter;

public class MainMenu {

	private static final char KEY_EXIT = '0';
	
	private List<String> options;
	
	public MainMenu() {
		initOptions();
	}
	private void initOptions() {
		options = new ArrayList<>();
		options.add("[1] Generate persistence.xml for JPA 2.0");
		options.add("[2] Generate hibernate.cfg.xml for Hibernate 5");
		options.add("[0] Exit");
	}
	
	public void start() {
		printMenuHeader();
		printOptions();
		mainLoop();
	}
	
	private void printMenuHeader() {
		ConsoleWriter.print("Choose an option ...");
	}
	
	private void printOptions() {
		ConsoleWriter.print(options);
	}
	
	public void mainLoop() {
		char enteredChar = 0;
		do {
			ConsoleWriter.printUserPrefix();
			enteredChar = ConsoleReader.readChar();
			doAction(enteredChar);
		} while (enteredChar != KEY_EXIT);

	}
	
	private void doAction(char enteredChar) {
		switch (enteredChar) {
			case '1' : 
				new JpaGenerator();
				break;
			case '2' :
				new HibernateGenerator();
				break;
			default : 
				break;
		}
	}
}
