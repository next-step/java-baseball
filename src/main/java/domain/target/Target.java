package domain.target;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Target {
	private final int BALL_COUNT = 3;
	private List<Ball> balls = new ArrayList<>();

	public static Target newBalls() {
		return new Target();
	}

	private Target() {
		setUpBalls();
	}

	private void setUpBalls() {
		while (balls.size() != BALL_COUNT) {
			ifBallsNotContainsAdd(BallGenerator.generate());
		}
	}

	private void ifBallsNotContainsAdd(Ball ball) {
		if (!balls.contains(ball)) {
			balls.add(ball);
		}
	}

	public List<Ball> getBalls() {
		return Collections.unmodifiableList(balls);
	}
}
