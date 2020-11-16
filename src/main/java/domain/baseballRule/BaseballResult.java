package domain.baseballRule;

public class BaseballResult {

	Strike strike;
	Ball ball;

	public BaseballResult() {
		this.strike = Strike.newZeroStrike();
		this.ball = Ball.newZeroBall();
	}

	public void add(BaseballResult baseballResult) {
		this.strike.add(baseballResult.strike);
		this.ball.add(baseballResult.ball);
	}

	public Boolean isThreeStrike() {
		return this.strike.strike.equals(3);
	}

	public Boolean isNothing() {
		return this.strike.strike.equals(0) && this.ball.ball.equals(0);
	}

	public Boolean isStrikeAndBall() {
		return this.getStrikeCount() > 0 && this.getBallCount() > 0;
	}

	public Boolean isOnlyStrike() {
		return this.getStrikeCount() > 0 && this.getBallCount() == 0;
	}

	public Boolean isOnlyBall() {
		return this.getStrikeCount() == 0 && this.getBallCount() > 0;
	}

	public void addStrike(Strike strike) {
		this.strike.add(strike);
	}

	public void addBall(Ball ball) {
		this.ball.add(ball);
	}

	public Integer getStrikeCount() {
		return this.strike.strike;
	}

	public Integer getBallCount() {
		return this.ball.ball;
	}

}
