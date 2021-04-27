import java.util.Scanner;

/**
 * @fileName        : NumberBaseball.java
 * @author          : Sunghwa Lee
 * @description     : Class in charge of user interface logic of the game
 */
public class NumberBaseball {
	private static final int maxDigit = 3;
	private static final String replayCommand = "1";
	private static final String terminateCommand = "2";
	private static final Scanner scanner = new Scanner(System.in);
	private static String answer;

	public static void main(String[] args) {
		boolean isReplay;
		do {
			playGame();
			isReplay = askReplay();
		} while (isReplay);
	}

	/**
	 * @methodName  : playGame
	 * @author      : Sunghwa Lee
	 * @description : Play the game until get the correct answer
	 */
	private static void playGame() {
		answer = BaseballCalculator.getRandomAnswer(maxDigit);
		boolean isCorrectAnswer = false;

		while (!isCorrectAnswer) {
			System.out.println("숫자를 입력해주세요: ");
			isCorrectAnswer = scoreInput();
		}
	}

	/**
	 * @methodName  : scoreInput
	 * @author      : Sunghwa Lee
	 * @description : Scoring the input string
	 * @return Return true if the input is correct
	 */
	private static boolean scoreInput() {
		String input = scanner.next();
		int strikeCount = BaseballCalculator.getStrikeCount(answer, input);
		if (strikeCount == maxDigit) {
			System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료.%n", maxDigit);
			return true;
		}
		int ballCount = BaseballCalculator.getBallCount(answer, input);
		System.out.println(buildResultString(strikeCount, ballCount));
		return false;
	}

	/**
	 * @methodName  : buildResultString
	 * @author      : Sunghwa Lee
	 * @description : Build the result string to be displayed
	 * @param strikeCount Count of strikes to be displayed
	 * @param ballCount Count of balls to be displayed
	 * @return Built result string
	 */
	private static String buildResultString(int strikeCount, int ballCount) {
		StringBuilder result = new StringBuilder();
		if (strikeCount > 0) {
			result.append(String.format("%d 스트라이크 ", strikeCount));
		}
		if (ballCount > 0) {
			result.append(String.format("%d 볼", ballCount));
		}
		return result.toString();
	}

	/**
	 * @methodName  : askReplay
	 * @author      : Sunghwa Lee
	 * @description : Ask the user if the want to replay
	 * @return Return true if the user want to replay
	 */
	private static boolean askReplay() {
		String input;
		System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%n", replayCommand, terminateCommand);
		input = scanner.next();
		while (!input.equals(replayCommand) && !input.equals(terminateCommand)) {
			System.out.printf("잘 못 입력하셨습니다.%n게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%n", replayCommand, terminateCommand);
			input = scanner.next();
		}
		return input.equals(replayCommand);
	}
}
