package com.coderhglee.game.exception;

public class NotAllowValueException extends GameException {
	@Override
	public String getMessage() {
		return GameExceptionMessage.NOT_ALLOW_VALUE_MESSAGE.message;
	}
}
