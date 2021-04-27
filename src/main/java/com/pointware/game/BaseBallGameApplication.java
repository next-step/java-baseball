package com.pointware.game;

import com.pointware.game.constant.GameState;
import com.pointware.game.input.GamePlayInputManager;

public class BaseBallGameApplication {
	public static void main(String[] args) {
		GamePlayInputManager gamePlayInputManager = new GamePlayInputManager();
		GameState gameState = GameState.PLAY;
		while (gameState.equals(GameState.PLAY)) {
			new Game().start();
			gameState = GameState.from(gamePlayInputManager.getInput());
		}
	}
}
