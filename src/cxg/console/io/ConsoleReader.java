package cxg.console.io;

import java.util.Scanner;

public class ConsoleReader {
	
	public static Scanner scanner;
	
	public static String readString() {
		scanner = new Scanner(System.in);
		String enteredString = scanner.nextLine();
		return enteredString;	
	}
	
	public static char readChar() {
		return readString().charAt(0);
	}
	
}
