package utils;

public class BaseballUtils {
	public static boolean isValidInput(String input) {
		if (input.length() != 3) {
			System.out.println("3자리로 입력해야합니다.");
			return false;
		}
		if (isNotInOneToNine(input.charAt(0))
			|| isNotInOneToNine(input.charAt(1))
			|| isNotInOneToNine(input.charAt(2))) {
			System.out.println("1에서 9까지의 숫자만 입력해야합니다.");
			return false;
		}
		return true;
	}

	private static boolean isNotInOneToNine(char number) {
		return number < '1' || number > '9';
	}
}
