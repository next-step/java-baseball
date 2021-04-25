package me.right42;

import me.right42.domain.Computer;
import me.right42.domain.Game;
import me.right42.domain.Gamer;
import me.right42.generator.RandomBallNumberGenerator;
import me.right42.generator.BallNumbersGenerator;

public class Application {

	public static void main(String[] args) {
		Gamer gamer = new Gamer();
		BallNumbersGenerator generator = new RandomBallNumberGenerator();
		Computer computer = new Computer(generator);

		Game game = new Game(gamer, computer);
		game.start();
	}

}
