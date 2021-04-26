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
}
