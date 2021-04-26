package baseball.enums;

public enum ReGameType {
	RE_GAME("1"),
	EXIT("2");

	private String typeNum;

	ReGameType(String typeNum) {
		this.typeNum = typeNum;
	}

	public String getTypeNum() {
		return typeNum;
	}
}
