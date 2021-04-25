package baseball;

import java.util.Scanner;

public class ScannerUtil {
	private static Scanner instance = null;

	private ScannerUtil() {

	}

	public static Scanner getInstance() {
		if (instance == null) {
			synchronized (Scanner.class) {
				if (instance == null) {
					instance = new Scanner(System.in);
				}
			}
		}
		return instance;
	}
}
