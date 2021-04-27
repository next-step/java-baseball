package gamemaster;

public enum BaseballPoint {
	NONE,
	STRIKE,
	BALL;

	public boolean isBall() {
		return this == BALL;
	}

	public boolean isStrike() {
		return this == STRIKE;
	}
}
