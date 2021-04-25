package baseball;

import baseball.player.Computer;
import baseball.player.User;

import java.util.Arrays;
import java.util.Scanner;

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
	private static final int BALL_COUNT = 3;

	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame();

		GameStatus gameStatus = READY;
		while (gameStatus != SHUTDOWN) {
			baseballGame.start();
			gameStatus = selectRestartOrExit();
		}
	}

	private void start() {
		Computer computer = new Computer();
		int[] computerBalls = computer.selectComputerBalls(BALL_COUNT);
		System.out.println("Computer: " + Arrays.toString(computerBalls));
		User user = new User();
		int[] userBalls = user.selectUserBalls(BALL_COUNT, inputUserBalls());
		System.out.println("User: " + Arrays.toString(userBalls));
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
}
