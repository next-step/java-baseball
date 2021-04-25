package baseball;

import java.util.ArrayList;
import java.util.List;

public class BallGenerator {

	private static List<Integer> balls;

	/**
	 * 1부터 9까지 3개의 무작위 볼을 생성
	 * @return 중복되지 않는 1부터 9사이의 무작위 볼 3개
	 */
	public static List<Integer> generateBalls() {
		initBall();

		List<Integer> ballNumbers = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			ballNumbers.add(pickupBall());
		}

		return ballNumbers;
	}

	/**
	 * 1부터 9까지의 공을 준비
	 */
	private static void initBall() {
		balls = new ArrayList<>();

		for (int i = 1; i < 10; i++) {
			balls.add(i);
		}
	}

	/**
	 * 배열에서 무작위로 공을 하나씩 뽑아낸다.
	 * 무작위 인덱스의 범위는 (0~9) * balls.size()
	 * @return 1~9 사이의 무작위 볼 하나
	 */
	private static int pickupBall() {
		int randomIndex = (int)(Math.random() * balls.size());

		int ball = balls.get(randomIndex);
		balls.remove(randomIndex);

		return ball;
	}
}
