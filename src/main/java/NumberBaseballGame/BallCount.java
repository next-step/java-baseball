package NumberBaseballGame;

public class BallCount {

	int strike;
	int ball;

	public BallCount() {
		strike = 0;
		ball = 0;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public void checkStrike(int index, int value, int indexAnswer, int valueAnswer) {
		if (index == indexAnswer && value == valueAnswer) {
			strike++;
		}
	}

	public void checkBall(int index, int value, int indexAnswer, int valueAnswer) {
		if (index != indexAnswer && value == valueAnswer) {
			ball++;
		}
	}

	public void addStrikeCount(int count) {
		strike += count;
	}

	public void addBallCount(int count) {
		ball += count;
	}
}