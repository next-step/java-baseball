package io.github.sejoung.baseball.domain;

import java.util.List;
import java.util.Set;

import io.github.sejoung.baseball.message.MessageMaker;

public class BaseBallNumber {
	private final List<Set<Integer>> computerNumberList;

	private final char[] numbers;

	private int strikeCount;

	private int ballCount;

	public BaseBallNumber(List<Set<Integer>> computerNumberList, String input) {
		this.computerNumberList = computerNumberList;
		this.numbers = input.toCharArray();
	}

	public boolean isThreeStrike() {
		return strikeCount == 3;
	}

	public String check() {
		strikeAndBallCheck();

		return MessageMaker.getPlayMessage(strikeCount, ballCount);
	}

	private void ballCheck(int index, int number) {
		for (int i = 0; i < computerNumberList.size(); i++) {
			ballCount(i, index, number);
		}
	}

	private void ballCount(int index, int parents, int number) {
		if (index != parents) {
			Set<Integer> numberSet = computerNumberList.get(index);
			ballCountAdd(numberSet, number);
		}
	}

	private void ballCountAdd(Set<Integer> numberSet, int number) {
		if (numberSet.contains(number)) {
			this.ballCount += 1;
		}
	}

	private void strikeAndBallCheck() {
		for (int i = 0; i < numbers.length; i++) {
			int temp = Character.getNumericValue(numbers[i]);
			strikeCheck(i, temp);
			ballCheck(i, temp);
		}
	}

	private void strikeCheck(int index, int number) {
		if (computerNumberList.get(index).contains(number)) {
			this.strikeCount += 1;
		}
	}
}
