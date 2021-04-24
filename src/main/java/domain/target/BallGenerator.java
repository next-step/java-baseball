package domain.target;

import java.util.Random;

public class BallGenerator {

	public static Ball generate() {
		Random random = new Random();
		return new Ball(random.nextInt(Ball.MAX_NUMBER_OF_BALL) + Ball.MIN_NUMBER_OF_BALL);
	}
}
