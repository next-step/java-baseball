package model;

public class Ball {
	public static final int BALL_MIN_NUMBER = 1;
	public static final int BALL_MAX_NUMBER = 9;

	private final int position;
	private final int ballNumber;

	public Ball(int position, int ballNumber) {
		validateRange(ballNumber);
		this.position = position;
		this.ballNumber = ballNumber;
	}

	public BallStatus play(Ball ball) {
		if (this.equals(ball)) {
			return BallStatus.STRIKE;
		}

		if (ball.matchBallNumber(ballNumber)) {
			return BallStatus.BALL;
		}

		return BallStatus.NOTHING;
	}

	private boolean matchBallNumber(int ballNumber) {
		return this.ballNumber == ballNumber;
	}

	private void validateRange(int ballNumber) {
		if (ballNumber < BALL_MIN_NUMBER || ballNumber > BALL_MAX_NUMBER) {
			throw new IllegalArgumentException("입력한 수가 1부터 9까지 정수가 아닙니다");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return position == ball.position && ballNumber == ball.ballNumber;
	}
}
