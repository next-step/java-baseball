package domain.target;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BallGenerator {

	public static Ball generateRandomBall() {
		Random random = new Random();
		return new Ball(random.nextInt(Ball.MAX_NUMBER_OF_BALL) + Ball.MIN_NUMBER_OF_BALL);
	}

	public static Balls generateBallsByNumber(int number) {
		List<Ball> ballList = new ArrayList<>();
		validateBallsNumber(number);
		List<Integer> dividedPerOneDigitNumber = divideNumberPerDigitOrderAsc(number);
		for (Integer num : dividedPerOneDigitNumber) {
			ballList.add(new Ball(num));
		}
		return new Balls(ballList);
	}

	private static void validateBallsNumber(int number) {
		if (number >= Math.pow(10, Balls.BALL_COUNT) || number < Math.pow(10, Balls.BALL_COUNT - 1)) {
			throw new IllegalArgumentException("숫자는" + Balls.BALL_COUNT + "자리 수 입니다.");
		}
	}

	private static List<Integer> divideNumberPerDigitOrderAsc(int number) {
		List<Integer> dividedNumberList = new ArrayList<>();
		while (number != 0) {
			dividedNumberList.add(number % 10);
			number /= 10;
		}
		Collections.reverse(dividedNumberList);
		return dividedNumberList;
	}
}
