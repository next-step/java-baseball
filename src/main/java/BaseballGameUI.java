import java.util.Scanner;

public class BaseballGameUI {
	private static Scanner scanner;
	private static BaseballGameLogic baseballGameLogic;
	private static BaseballGameNumber baseballGameNumber;

	public static void main(String[] args) {
		init();
		baseballGame();
	}

	private static void baseballGame() {
		String guessNumbers;
		boolean isContinue = true;

		while (isContinue) {
			if (!isInputValid(guessNumbers = askNumbers())) {
				continue;
			}

			System.out.println(baseballGameLogic.getScore(baseballGameNumber.getNumber(), guessNumbers));
			isContinue = isContinue(isCorrect(baseballGameLogic.getScore(baseballGameNumber.getNumber(), guessNumbers)));
		}
	}

	private static boolean isContinue(boolean isCorrect) {
		if (isCorrect) {
			return !isFinished();
		}

		return true;
	}

	private static void init() {
		scanner = new Scanner(System.in);
		baseballGameLogic = new BaseballGameLogic();
		baseballGameNumber = new BaseballGameNumber();
		baseballGameNumber.makeNumber();
	}

	private static boolean isCorrect(String score) {
		if ("3 스트라이크 ".equals(score)) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			return true;
		}

		return false;
	}

	private static boolean isFinished() {
		String input;

		do {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
			input = scanner.nextLine();
		} while (BaseballGameValidator.isAllowedNumbers(input));

		if ("1".equals(input)) {
			baseballGameNumber.makeNumber();
			return false;
		}

		return true;
	}

	private static String askNumbers() {
		System.out.print("숫자를입력해주세요 : ");
		return scanner.nextLine();
	}

	private static boolean isInputValid(String input) {
		if (!BaseballGameValidator.isLengthThree(input) || !BaseballGameValidator.isNumbers(input)) {
			return false;
		}

		return true;
	}
}
