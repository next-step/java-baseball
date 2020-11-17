package org.dhlee.game.baseball;

import java.util.List;

import org.dhlee.game.interfaces.Player;

public class BaseballPlayer implements Player {
	private String name;
	private List<Integer> numbers;

	public BaseballPlayer(String name) {
		this.name = name;
	}

	public BaseballPlayer(String name, List<Integer> numbers) {
		this.name = name;
		this.numbers = numbers;
	}

	public String getName() {
		return this.name;
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public void play() {

	}

}
