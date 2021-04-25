package baseball.domain;

public enum BaseballNumberMatch {

	STRIKE("스트라이크"), BALL("볼"), FOUR_BALL("포볼");

	private final String name;

	BaseballNumberMatch(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
