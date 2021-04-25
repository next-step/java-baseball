package common.code;

public enum HintType {
	STRIKE("STRIKE","스트라이크"),
	BALL("BALL","볼"),
	NOTHING("NOTHING","낫싱");
	
	private HintType(String hintCode, String hintValue) {
		this.hintCode = hintCode;
		this.hintValue = hintValue;
	}

	String hintCode;
	String hintValue;
	
	
	public String getHintCode() {
		return hintCode;
	}
	
	public String getHintValue() {
		return hintValue;
	}
	

}
