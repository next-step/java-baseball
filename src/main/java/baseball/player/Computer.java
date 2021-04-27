package baseball.player;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/25
 * Time : 12:49 AM
 */

public class Computer {
	public int[] selectComputerBalls(int ballCount) {
		Set<Integer> uniqueBalls = new HashSet<>();
		while (uniqueBalls.size() < ballCount) {
			int selectBall = selectNumber();
			uniqueBalls.add(selectBall);
		}
		return convertBallToArray(uniqueBalls);
	}

	private int selectNumber() {
		Random random = new Random();
		return random.nextInt(9) + 1;
	}

	private int[] convertBallToArray(Set<Integer> uniqueBalls) {
		int[] balls = new int[uniqueBalls.size()];
		int i = 0;
		for (Integer ball : uniqueBalls) {
			balls[i++] = ball;
		}
		return balls;
	}
}
