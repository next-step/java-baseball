package baseball.util;

import java.util.Scanner;

public class ScannerUtil {
	private ScannerUtil() {

	}

	public static String getUserInput() {
		return ScannerUtil.getInstance().nextLine();
	}

	private static class Holder {
		private static final Scanner instance = new Scanner(System.in);
	}

	public static Scanner getInstance() {
		return Holder.instance;
	}
}
