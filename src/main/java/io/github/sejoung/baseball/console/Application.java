package io.github.sejoung.baseball.console;

import java.util.Scanner;

import io.github.sejoung.baseball.BaseBallGame;
import io.github.sejoung.baseball.RandomBaseBallNumberGenerator;

public class Application {
	public static void main(String[] args) {
		BaseBallGame game = new BaseBallGame(new RandomBaseBallNumberGenerator());
		Scanner scanner = new Scanner(System.in);
		playGame(game, scanner);
	}

	private static void playGame(BaseBallGame game, Scanner scanner) {
		while (!game.isCompleted()) {
			System.out.println(game.flushOutput());
			game.processInput(scanner.nextLine());
		}
	}
}
