package io.chikeem90.github;

import io.chikeem90.github.service.RandomNumberGenerator;

public class Starter {
	public static void main(String[] args) {
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.startBaseballGame(new RandomNumberGenerator());
	}
}
