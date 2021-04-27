public class BaseballGameValidator {
	public static boolean isLengthThree(String input) {
		return input.length() == 3 ? true : false;
	}

	public static boolean isNumbers(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			return false;
		}

		return true;
	}

	public static boolean isAllowedNumbers(String input) {
		if (!"1".equals(input) && !"2".equals(input)) {
			return true;
		}

		return false;
	}

	public static boolean isNotZeroContained(String input) {
		if (input.indexOf('0') > -1) {
			return false;
		}

		return true;
	}
}
