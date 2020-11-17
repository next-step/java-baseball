package org.dhlee.game;

import org.dhlee.game.baseball.BaseballGame;
import org.dhlee.game.enums.ProgressType;

public class Main {
	public static void main(String[] args) {
		BaseballGame baseballGame = null;
		do {
			baseballGame = new BaseballGame();
			baseballGame.init();
			baseballGame.start();
		} while (!baseballGame.stop().equals(ProgressType.EXIT));
	}
}
