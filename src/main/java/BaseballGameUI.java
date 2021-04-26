import java.util.Scanner;

public class BaseballGameUI {
	private static Scanner scanner;

	public static void main(String[] args) {
		String input;
		boolean isContinue = true;
		scanner = new Scanner(System.in);
		BaseballGameLogic baseballGameLogic = new BaseballGameLogic();
		baseballGameLogic.makeNumber();

		while (isContinue) {
			if (inputValidation(input = askNumbers(scanner))) {
				continue;
			}
			System.out.println(baseballGameLogic.getNumber() + " / " + baseballGameLogic.getScore(input));
			isContinue = isCorrect(baseballGameLogic.getScore(input), baseballGameLogic);
		}
	}

	private static boolean isCorrect(String score, BaseballGameLogic baseballGameLogic) {
		if ("3 스트라이크 ".equals(score)) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			return isFinished(baseballGameLogic);
		}

		return true;
	}

	private static boolean isFinished(BaseballGameLogic baseballGameLogic) {
		String input;

		do {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
			input = scanner.nextLine();
		} while (BaseballGameValidator.isAllowedNumbers(input));

		if ("1".equals(input)) {
			baseballGameLogic.makeNumber();
			return true;
		}

		return false;
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
