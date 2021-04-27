package baseball.domain;

public class Validator {

	public static boolean isValidLength(String text) {
		return text.length() == Game.NUMBER_LENGTH;
	}

	public static boolean isValidLength(int[] numbers) {
		return numbers.length == Game.NUMBER_LENGTH;
	}

	private static boolean isInRange(int number) {
		return 0 <= number && number <= 9;
	}

	public static boolean isInRange(int[] numbers) {
		for (int n: numbers) {
			boolean isValid = isInRange(n);
			if(!isValid) return false;
		}

		return true;
	}
}
