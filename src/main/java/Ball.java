
public class Ball {
	private int index;
	private int number;
	private boolean ball;
	private boolean strike;

	public Ball(int index, int number) {
		this.index = index;
		this.number = number;
	}

	public boolean isBall() {
		return ball;
	}

	public boolean isStrike() {
		return strike;
	}

	public void ball() {
		if (strike) {
			return;
		}

		ball = true;
	}

	public void strike() {
		if (ball) {
			return;
		}

		strike = true;
	}

	public boolean contains(Ball item) {
		return this.number == item.number;
	}

	public void setScore(Ball item) {
		if (this.index == item.index && this.number == item.number) {
			strike = true;
		}

		if (this.index != item.index && this.number == item.number) {
			ball = true;
		}
	}
}
