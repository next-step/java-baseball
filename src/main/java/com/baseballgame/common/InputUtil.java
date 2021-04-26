package com.baseballgame.common;

import java.util.Scanner;

public class InputUtil {
	private InputUtil(){}

	public static String inputWithScanner(){
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}

}
