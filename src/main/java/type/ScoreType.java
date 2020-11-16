package type;

public enum ScoreType {
	STRIKE("스트라이크", true),
	BALL("볼", true),
	NONE("낫싱", false);
	
	private final String description;
	
	private final boolean printable;
	
	ScoreType(String description, boolean printable) {
		this.description = description;
		this.printable = printable;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isPrintable() {
		return printable;
	}
	
	public String printWithScore(int score) {
		if (this.printable) {
			return score + this.description;
		}
		
		return "";
	}
}