package baseball;

import baseball.player.Computer;
import baseball.player.User;

import java.util.Arrays;
import java.util.Scanner;

import static baseball.BaseballGame.BaseballType.BALL;
import static baseball.BaseballGame.BaseballType.NOTHING;
import static baseball.BaseballGame.BaseballType.STRIKE;
import static baseball.BaseballGame.GameStatus.READY;
import static baseball.BaseballGame.GameStatus.RESTART;
import static baseball.BaseballGame.GameStatus.SHUTDOWN;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/25
 * Time : 1:03 AM
 */

public class BaseballGame {
	private static final int DEFAULT_BALL_COUNT = 3;

	private int ballCount;

	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame(DEFAULT_BALL_COUNT);
		Computer computer = new Computer();
		User user = new User();
		GameStatus gameStatus = READY;
		while (gameStatus != SHUTDOWN) {
			baseballGame.start(computer, user);
			gameStatus = selectRestartOrExit();
		}
	}

	public BaseballGame(int ballCount) {
		this.ballCount = ballCount;
	}

	private void start(Computer computer, User user) {
		int[] computerBalls = computer.selectComputerBalls(ballCount);
		while (!match(computerBalls, user.selectUserBalls(ballCount, inputUserBalls())));
		System.out.println(ballCount + "개의 숫자를 모두 맞히셨습니다! 게임종료");
	}

	private boolean match(int[] computerBalls, int[] userBalls) {
		int strike = 0, ball = 0;
		for (int i = 0; i < ballCount; ++i) {
			strike += tryStrike(computerBalls, userBalls, i);
			ball   += tryBall(computerBalls, userBalls, i);
		}
		System.out.println(createResultMessage(strike, ball));
		return strike == ballCount;
	}

	private int tryStrike(int[] computerBalls, int[] userBalls, int idx) {
		return computerBalls[idx] == userBalls[idx] ? 1 : 0;
	}

	private int tryBall(int[] computerBalls, int[] userBalls, int idx) {
		if (tryStrike(computerBalls, userBalls, idx) == 1) {
			return 0;
		}
		return Arrays.binarySearch(computerBalls, userBalls[idx]) >= 0 ? 1 : 0;
	}

	private String createResultMessage(int strike, int ball) {
		StringBuilder sb = new StringBuilder();
		if (strike > 0) {
			sb.append(strike).append(STRIKE.type()).append(" ");
		}
		if (ball > 0) {
			sb.append(ball).append(BALL.type());
		}
		return strike == 0 && ball == 0 ? NOTHING.type() : sb.toString();
	}

	private static GameStatus selectRestartOrExit() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt() == 1 ? RESTART : SHUTDOWN;
	}

	private String inputUserBalls() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요: ");
		return scanner.next();
	}

	enum GameStatus {
		READY,
		RESTART,
		SHUTDOWN
	}

	enum BaseballType {
		STRIKE("스트라이크"),
		BALL("볼"),
		NOTHING("낫싱");

		BaseballType(String type) {
			this.type = type;
		}

		public String type() {
			return type;
		}

		private String type;
	}
}
