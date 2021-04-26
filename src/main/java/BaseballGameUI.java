import java.util.Scanner;

public class BaseballGameUI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		boolean isContinue = true;

		BaseballGameLogic baseballGameLogic = new BaseballGameLogic();
		baseballGameLogic.makeNumber();

		while (isContinue) {
			if (inputValidation(input = askNumbers(scanner))) {
				continue;
			}

			System.out.println(baseballGameLogic.getScore(input));
		}
	}

	private static String askNumbers(Scanner scanner) {
		System.out.print("숫자를입력해주세요 : ");
		return scanner.nextLine();
	}

	private static boolean inputValidation(String input) {
		if (!BaseballGameValidator.isLengthThree(input) || !BaseballGameValidator.isNumbers(input)) {
			return true;
		}

		return false;
	}
}
