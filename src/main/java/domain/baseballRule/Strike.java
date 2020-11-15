package domain.baseballRule;

public class Strike {
	Integer strike;

	private Strike(Integer strike) {
		this.strike = strike;
	}

	public static Strike newZeroStrike() {
		return new Strike(0);
	}

	public static Strike newOneStrike() {
		return new Strike(1);
	}

	public void add(Strike strike) {
		this.strike += strike.strike;
	}

	public Boolean isStrike() {
		return this.strike.equals(1);
	}

}
