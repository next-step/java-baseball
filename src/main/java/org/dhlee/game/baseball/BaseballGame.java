package org.dhlee.game.baseball;

import java.util.Scanner;

import org.dhlee.game.interfaces.Game;

public class BaseballGame implements Game {
	private Scanner scanner;
	private BaseballPlayer defensePlayer;
	private BaseballPlayer attackPlayer;

	public BaseballGame() {
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void init() {
		this.defensePlayer = new BaseballPlayer("Computer");
		this.attackPlayer = new BaseballPlayer("Player");
	}

	@Override
	public void start() {
	}

	private boolean play(String input) {
		return true;
	}

	@Override
	public void stop() {
	}
}
