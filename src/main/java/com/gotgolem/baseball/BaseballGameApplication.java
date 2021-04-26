package com.gotgolem.baseball;

import com.gotgolem.baseball.manager.GameManager;

public class BaseballGameApplication {
	public static void main(String[] args) {
		final GameManager gameManager = new GameManager();
		gameManager.play();
	}
}
