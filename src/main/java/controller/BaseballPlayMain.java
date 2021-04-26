package controller;

import baseball.BaseballPlay;
import template.BaseballTemplate;

public class BaseballPlayMain {

	public static void main(String[] args) {
		BaseballTemplate game = null;
		
		boolean gameStauts = true;
		while(gameStauts) {
			game = new BaseballPlay();
			gameStauts = game.run();
		};

	}

}
