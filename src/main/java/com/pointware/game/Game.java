package com.pointware.game;

import com.pointware.game.input.PlayerInputManager;
import com.pointware.game.util.RandomNumber;
import com.pointware.game.validation.GameNumberValidationResult;
import com.pointware.game.validation.GameNumberValidator;

public class Game {

	private final Integer randomNumber;
	private final PlayerInputManager playerInputManager;
	private final GameNumberValidator validator;

	public Game() {
		randomNumber = new RandomNumber().generateNumber(3);
		validator = new GameNumberValidator();
		playerInputManager = new PlayerInputManager();
	}

	public void start() {
		while (!nextRound()) {
		}
	}

	private boolean nextRound() {
		int playerNumber = playerInputManager.getInput();
		return roundTest(playerNumber);
	}

	private boolean roundTest(int number) {
		GameNumberValidationResult validationResult = validator.validate(randomNumber, number);
		printResult(validationResult);
		if (validationResult.isEnd()) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
		return validationResult.isEnd();
	}

	private void printResult(GameNumberValidationResult validationResult) {
		System.out.println(GameResultMessage.of(validationResult).getMessage());
	}
}
