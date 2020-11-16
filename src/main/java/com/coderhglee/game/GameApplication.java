package com.coderhglee.game;

import com.coderhglee.game.baseball.BaseballGameUI;
import com.coderhglee.game.exception.GameException;

public class GameApplication {

	public static void main(String[] args) throws GameException {
		BaseballGameUI.executeGame();
	}
}
