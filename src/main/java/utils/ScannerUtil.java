package utils;

import java.util.Scanner;

public class ScannerUtil {
	private ScannerUtil() {

	}

	public static Scanner getInstance() {
		return LazyHolder.INSTANCE;
	}

	private static class LazyHolder {
		private static final Scanner INSTANCE = new Scanner(System.in);
	}
}
