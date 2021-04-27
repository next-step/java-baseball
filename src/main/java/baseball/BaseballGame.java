package baseball;

import baseball.player.Computer;
import baseball.player.User;
import baseball.ui.BaseballGameUI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static baseball.BaseballGame.BaseballType.*;
import static baseball.GameStatus.RESTART;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/25
 * Time : 1:03 AM
 */

public class BaseballGame {
	private Map<BaseballType, Integer> result = new HashMap<>();

	private BaseballGameUI baseballGameUI = new BaseballGameUI();

	private final int ballCount;

	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame(3);
		Computer computer = new Computer();
		User user = new User();
		baseballGame.start(computer, user);
	}

	public BaseballGame(int ballCount) {
		this.ballCount = ballCount;
	}

	private void start(Computer computer, User user) {
		int[] computerBalls = computer.selectComputerBalls(ballCount);
		while (!match(computerBalls, user.selectUserBalls(ballCount, baseballGameUI.inputUserBalls()))) {
			baseballGameUI.print(createResultMessage(
				result.getOrDefault(STRIKE, 0), result.getOrDefault(BALL, 0)));
		}
		baseballGameUI.print(ballCount + "개의 숫자를 모두 맞히셨습니다! 게임종료");
		if (isSelectedRestart()) {
			start(computer, user);
		}
	}

	private boolean isSelectedRestart() {
		return baseballGameUI.selectRestartOrExit() == RESTART;
	}

	private boolean match(int[] computerBalls, int[] userBalls) {
		result.clear();
		for (int i = 0; i < ballCount; ++i) {
			result.put(STRIKE, result.getOrDefault(STRIKE, 0) + tryStrike(computerBalls, userBalls, i));
			result.put(BALL, result.getOrDefault(BALL, 0) + tryBall(computerBalls, userBalls, i));
		}
		return result.getOrDefault(STRIKE, 0) == ballCount;
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
