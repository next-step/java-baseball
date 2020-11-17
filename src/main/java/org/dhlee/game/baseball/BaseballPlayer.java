package org.dhlee.game.baseball;

import java.util.List;

import org.dhlee.game.interfaces.Player;
import org.dhlee.game.utils.CompareUtils;

public class BaseballPlayer implements Player<PlayResult> {
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
	public PlayResult play(List<Integer> value) {
		int strikeCount = getStrikeCount(value);
		int ballCount = getBallCount(value);
		return new PlayResult(strikeCount, ballCount);
	}

	public int getStrikeCount(List<Integer> value) {
		int count = 0;
		for (int i = 0; i < value.size(); i++) {
			count = CompareUtils.compareNumbers(this.numbers.get(i), value.get(i))
				? count + 1
				: count;
		}
		return count;
	}

	public int getBallCount(List<Integer> value) {
		int count = 0;
		for (int i = 0; i < value.size(); i++) {
			count =
				!CompareUtils.compareNumbers(this.numbers.get(i), value.get(i)) && this.numbers.contains(value.get(i))
					? count + 1
					: count;
		}
		return count;
	}

}
