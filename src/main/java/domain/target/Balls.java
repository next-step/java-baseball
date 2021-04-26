package domain.target;

import constant.GameRule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Balls {
	private List<Ball> ballList = new ArrayList<>();

	public static Balls createNewTargetBalls() {
		return new Balls();
	}

	public Balls(List<Ball> ballList) {
		validateBallList(ballList);
		this.ballList = ballList;
	}

	private Balls() {
		setUpBalls();
	}

	private void validateBallList(List<Ball> ballList) {
		if (ballList.size() != GameRule.BALL_COUNT) {
			throw new IllegalArgumentException("Balls 의 크기는" + GameRule.BALL_COUNT + "이어야 합니다.");
		}
	}

	private void setUpBalls() {
		while (ballList.size() != GameRule.BALL_COUNT) {
			ifBallsNotContainsAdd(BallGenerator.generateRandomBall());
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
