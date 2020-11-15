package service;

public enum BaseballCount {
	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("낫싱");

	BaseballCount(String name) {
		this.name = name;
	}

	private final String name;
	public String getName() {
		return name;
	}
}
