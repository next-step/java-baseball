package org.dhlee.game;

import org.dhlee.game.baseball.BaseballGame;

public class Main {
	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.init();
		baseballGame.start();
	}
}
