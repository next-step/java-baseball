public class Hint {
	private final int strike;
	private final int ball;

	public Hint(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}
	public int getStrike(){
		return strike;
	}
	public int getBall(){
		return ball;
	}
	public boolean is3Strike() {
		return strike == 3;
	}

	public boolean isNothing() {
		return ball == 0 && strike == 0;
	}

}
