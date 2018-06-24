package cxg.console.io;

import java.util.List;

public class ConsoleWriter {

	private static final String PREFIX_USER = "User : ";
	private static final String PREFIX_CPU = "Generator : ";
	
	public static void print(String arg) {
		System.out.println(PREFIX_CPU + arg);
	}
	
	public static void print(List<String> list) {
		for(String s: list)
			System.out.println(s);
	}
	
	public static void printUserPrefix() {
		System.out.print(PREFIX_USER);
	}
	
}
