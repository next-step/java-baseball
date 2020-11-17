package bymin.game.constans;

public enum Rule {
	REGAME("1"), STOP("2"), RELOAD("0");

	String playType;

	Rule(String playType) {
		this.playType = playType;
	}


	public String getPlayType() {
		return playType;
	}

	public void setPlayType(String playType) {
		this.playType = playType;
	}
}
