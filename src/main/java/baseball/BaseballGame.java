package baseball;

import baseball.player.Computer;

import java.util.Arrays;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/25
 * Time : 1:03 AM
 */

public class BaseballGame {
	private static final int BALL_COUNT = 3;

	public static void main(String[] args) {
		Computer computer = new Computer();
		int[] computerBalls = computer.selectComputerBalls(BALL_COUNT);
		System.out.println("Computer: " + Arrays.toString(computerBalls));
	}
}
