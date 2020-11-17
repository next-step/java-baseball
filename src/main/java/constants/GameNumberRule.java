package constants;

public enum GameNumberRule {
	LENGTH(3),
	MAX_NUMBER(9),
	MIN_NUMBER(1);
	private final int rule;
	GameNumberRule(int rule) {
		this.rule = rule;
	}
	public int getValue() {
		return rule;
	}
}
