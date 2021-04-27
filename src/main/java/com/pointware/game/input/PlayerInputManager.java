package com.pointware.game.input;

import java.util.function.Predicate;

public class PlayerInputManager extends InputManager{
	@Override
	protected String getMessage() {
		return "숫자를 입력해주세요 :";
	}

	@Override
	protected Predicate<Integer> getValidator() {
		return input -> input > 122 && input < 988;
	}
}
