package com.baseballgame;

import com.baseballgame.domain.Computer;
import com.baseballgame.domain.Game;
import com.baseballgame.domain.User;

public class BaseballGameApplication {
	public static void main(String[] args) {
		Game game = new Game(new Computer(), new User());
		game.start();
	}
}
