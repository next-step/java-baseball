package me.right42;

import me.right42.domain.Computer;
import me.right42.domain.Game;
import me.right42.domain.Gamer;

public class Application {

	public static void main(String[] args) {
		Gamer gamer = new Gamer();
		Computer computer = new Computer();

		Game game = new Game(gamer, computer);
		game.start();
	}

}
