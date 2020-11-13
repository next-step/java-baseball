package com.woowahan.camp.util;

public class ValidationUtil {
	public static boolean isNotNumber(String strNum) {
		if (strNum == null) {
			return true;
		}
		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return true;
		}
		return false;
	}

	public static boolean isNotLengthThree(String strNum) {
		if (strNum == null) {
			return true;
		}
		if (strNum.length() == 3) {
			return false;
		}
		return true;
	}
}
