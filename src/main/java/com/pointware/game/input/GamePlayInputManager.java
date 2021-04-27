package com.pointware.game.input;

import java.util.function.Predicate;

public class GamePlayInputManager extends InputManager{
	@Override
	protected String getMessage() {
		return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
	}

	@Override
	protected Predicate<Integer> getValidator() {
		return input -> input > 0 && input < 3;
	}
}
