package com.coderhglee.game.number;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Number {
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9);

	public static final Map<Integer, Number> gameNumberMap = Collections.unmodifiableMap(getBaseballNumberMap());

	private final int number;

	Number(int value) {
		this.number = value;
	}

	public int getNumberValue() {
		return number;
	}

	private static Map<Integer, Number> getBaseballNumberMap() {
		Map<Integer, Number> newMap = new HashMap<>();
		for (Number number : values()) {
			newMap.put(number.getNumberValue(), number);
		}
		return newMap;
	}
}
