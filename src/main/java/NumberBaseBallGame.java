import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import dto.BallCount;
import exception.InvalidValueException;
import service.IInitializer;
import service.IMatchingSystem;
import service.impl.Initializer;
import service.impl.MatchingSystem;

public class NumberBaseBallGame {

	private final static int MAX_DIGIT_NUMBER = 3;
	private final static IInitializer initializer = new Initializer(MAX_DIGIT_NUMBER);
	private final static IMatchingSystem matchingSystem = new MatchingSystem(MAX_DIGIT_NUMBER);

	public static void main(String[] args) {
		final Map<Integer, Integer> computerNumber = initializer.initComputerNumber();
		boolean gameOver = false;
		while (!gameOver) {
			gameOver = runningGameStage(computerNumber);
		}
	}

	/**
	 * 게임 스테이지를 진행
	 */
	private static boolean runningGameStage(final Map<Integer, Integer> computerNumber) {
		System.out.print("숫자를 입력해주세요 : ");
		try {
			final BallCount ballCount = matchingSystem.match(
				computerNumber, initializer.initPlayerNumber(new Scanner(System.in).nextInt()));
			printBallCount(ballCount);
			return ballCount.getStrike() == 3;
		} catch (InvalidValueException | InputMismatchException e) {
			System.out.println("유효하지 않은 숫자입니다!");
			return false;
		}
	}

	/**
	 * 볼 카운트 출력
	 */
	private static void printBallCount(final BallCount ballCount) {
		if (ballCount.getStrike() == 0 && ballCount.getBall() == 0) {
			System.out.println("낫싱");
			return;
		}
		StringBuilder stringBuilder = new StringBuilder();
		if (ballCount.getStrike() != 0)
			stringBuilder.append(ballCount.getStrike()).append(" 스트라이크 ");
		if (ballCount.getBall() != 0)
			stringBuilder.append(ballCount.getStrike()).append(" 볼");
		System.out.println(stringBuilder.toString().trim());
	}
}
