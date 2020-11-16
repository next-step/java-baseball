package app;

public enum GameNumberRule {
	LENGTH(3),
	MAX(9),
	MIN(1);
	private final int gameNumberRule;
	GameNumberRule(int gameNumberRule) {
		this.gameNumberRule = gameNumberRule;
	}
	public int getValue() {
		return gameNumberRule;
	}
}
