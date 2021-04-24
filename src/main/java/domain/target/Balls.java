package domain.target;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Balls {
	private final int BALL_COUNT = 3;
	private List<Ball> ballList = new ArrayList<>();

	public static Balls newBalls() {
		return new Balls();
	}

	private Balls() {
		setUpBalls();
	}

	private void setUpBalls() {
		while (ballList.size() != BALL_COUNT) {
			ifBallsNotContainsAdd(BallGenerator.generate());
		}
	}

	private void ifBallsNotContainsAdd(Ball ball) {
		if (!ballList.contains(ball)) {
			ballList.add(ball);
		}
	}

	public List<Ball> getBallList() {
		return Collections.unmodifiableList(ballList);
	}
}
