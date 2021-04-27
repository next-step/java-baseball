package com.tistory.ddoriya.constants;

/**
 * @author 이상준
 */
public enum GameType {
	STRIKE("스트라이크"),
	BALL("볼"),
	NOTHING("낫싱");

	GameType(String type) {
		this.type = type;
	}

	final private String type;

	public String getType() {
		return type;
	}
}
