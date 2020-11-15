package domain.baseballRule;

public class BaseballResult {

	Boolean match;
	Strike strike;
	Ball ball;

	public BaseballResult(){
		this.match = false;
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

	public void setMatchTrue() {
		this.match = true;
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

	public Boolean isMatch(){
		return this.match;
	}
}
