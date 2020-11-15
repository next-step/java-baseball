package domain.baseballRule;

public class Ball {
	Integer ball;

	private Ball(Integer ball) {
		this.ball = ball;
	}

	public static Ball newOneBall() {
		return new Ball(1);
	}

	public static Ball newZeroBall() {
		return new Ball(0);
	}

	public void add(Ball ball) {
		this.ball += ball.ball;
	}
}
