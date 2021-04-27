import java.util.Scanner;

/**
 * @fileName        : NumberBaseball.java
 * @author          : Sunghwa Lee
 * @description     : Class in charge of user interface logic of the game
 */
public class NumberBaseball {
	private static final String replayCommand = "1";
	private static final String terminateCommand = "2";
	private static final Scanner scanner = new Scanner(System.in);

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
