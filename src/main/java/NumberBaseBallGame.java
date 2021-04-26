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

	private static Map<Integer, Integer> computerNumber;

	public static void main(String[] args) {
		runningGame();
	}

	/**
	 * 게임 실행
	 */
	private static void runningGame() {
		computerNumber = initializer.initComputerNumber();
		boolean gameOver = false;
		while (!gameOver) {
			gameOver = nextTurn();
		}
	}

	/**
	 * 다음 턴 시작
	 */
	private static boolean nextTurn() {
		System.out.print("숫자를 입력해주세요 : ");
		try {
			return checkGameOver(printBallCount(matchingSystem.match(
				computerNumber,
				initializer.initPlayerNumber(new Scanner(System.in).nextInt())
			)));
		} catch (InvalidValueException | InputMismatchException e) {
			System.out.println("유효하지 않은 숫자입니다!");
			return false;
		}
	}

	/**
	 * 볼 카운트 출력
	 */
	private static BallCount printBallCount(final BallCount ballCount) {
		StringBuilder stringBuilder = new StringBuilder();
		if (ballCount.getStrike() == 0 && ballCount.getBall() == 0)
			stringBuilder.append("낫싱");
		if (ballCount.getStrike() != 0)
			stringBuilder.append(ballCount.getStrike()).append(" 스트라이크 ");
		if (ballCount.getBall() != 0)
			stringBuilder.append(ballCount.getBall()).append(" 볼");
		System.out.println(stringBuilder.toString().trim());
		return ballCount;
	}

	/**
	 * 게임 종료 여부 확인
	 */
	private static boolean checkGameOver(final BallCount ballCount) {
		final boolean gameOver = ballCount.getStrike() == 3;
		boolean isNewGame = false;
		if (gameOver) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			isNewGame = isNewGame();
		}
		if (isNewGame) {
			computerNumber = initializer.initComputerNumber();
		}
		return gameOver && !isNewGame;
	}

	/**
	 * 게임을 새로 시작할지 질의
	 */
	private static boolean isNewGame() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		try {
			return new Scanner(System.in).nextInt() == 1;
		} catch (InputMismatchException e) {
			return false;
		}
	}
}
