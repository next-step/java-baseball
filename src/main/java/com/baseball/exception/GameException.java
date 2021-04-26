package com.baseball.exception;

public class GameException {

	public static void throwValidationException(String message) {
		throw new IllegalArgumentException(message);
	}

}
