package baseball;

import baseball.player.Computer;
import baseball.player.User;

import java.util.Arrays;
import java.util.Scanner;

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
		Computer computer = new Computer();
		int[] computerBalls = computer.selectComputerBalls(BALL_COUNT);
		System.out.println("Computer: " + Arrays.toString(computerBalls));
		User user = new User();
		int[] userBalls = user.selectUserBalls(BALL_COUNT, baseballGame.inputUserBalls());
		System.out.println("User: " + Arrays.toString(userBalls));
	}

	private String inputUserBalls() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요: ");
		return scanner.next();
	}
}
