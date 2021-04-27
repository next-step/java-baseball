package task.baseball;

import java.util.List;
import java.util.Scanner;

public class BaseballMain {

	static final int GO = 1;
	static final int STOP = 2;
	private final BaseballService baseballService = new BaseballService();

	public int inputGoOrStop(Scanner scanner) {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		while (true) {
			String input = scanner.next();

			if (input.length() == 1 || Character.isDigit(input.charAt(0))) {
				int convertedInput = Character.getNumericValue(input.charAt(0));
				if (convertedInput == GO || convertedInput == STOP) {
					return convertedInput;
				}
			}
			System.err.println("1 또는 2만 입력 가능 합니다.");
		}
	}

	public void playGame(Scanner scanner) {

		List<Integer> answer = baseballService.generateRandomAnswer();

		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			String input = scanner.next();

			List<Integer> convertedInput;
			try {
				convertedInput = baseballService.validateInputAndConvert(input);
			} catch (IllegalArgumentException e) {
				System.err.println("\n" + e.getMessage());
				continue;
			}

			int strikeCount = baseballService.getStrikeCount(convertedInput, answer);
			if (baseballService.isAnswer(strikeCount)) {
				break;
			}

			int ballCount = baseballService.getBallCount(convertedInput, answer);
			if (baseballService.isNothing(strikeCount, ballCount)) {
				System.out.println(baseballService.generateNotThingOutputMessage());
				continue;
			}

			System.out.println(baseballService.generateOutputMessage(strikeCount, ballCount));
		}
		System.out.println(baseballService.generateAnswerOutputMessage());
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseballMain baseballMain = new BaseballMain();

		int goOrStop = BaseballMain.GO;

		while (goOrStop == BaseballMain.GO) {
			baseballMain.playGame(scanner);
			goOrStop = baseballMain.inputGoOrStop(scanner);
		}
	}
}
