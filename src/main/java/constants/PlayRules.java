package constants;

public enum PlayRules {
	BALL_LENGTH(3),
	MAX_NUMBER(9),
	MIN_NUMBER(1);

	private int rule;

	PlayRules(int rule) {
		this.rule = rule;
	}

	public int value() {
		return rule;
	}
}
