package type;

public enum ScoreType {
	STRIKE("스트라이크", true),
	BALL("볼", true),
	NONE("낫싱", false);
	
	private final String description;
	
	private final boolean needPrint;
	
	ScoreType(String description, boolean needPrint) {
		this.description = description;
		this.needPrint = needPrint;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean needPrint() {
		return needPrint;
	}
	
	public String print(int count) {
		if (this.needPrint) {
			return count + this.description;
		}
		
		return "";
	}
}