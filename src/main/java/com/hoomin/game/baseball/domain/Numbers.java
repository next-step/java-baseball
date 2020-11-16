package com.hoomin.game.baseball.domain;

import java.util.HashSet;
import java.util.List;

import com.hoomin.game.baseball.enums.HintState;

public class Numbers {
	private static final int NUMBER_SIZE = 3;
	private final List<Integer> numberList;

	public Numbers(List<Integer> numberList) {
		validateSize(numberList);
		validateNumber(numberList);
		validateDuplicate(numberList);
		this.numberList = numberList;
	}

	private void validateDuplicate(List<Integer> numberList) {
		if (numberList.size() != new HashSet<>(numberList).size()) {
			throw new IllegalArgumentException("중복되지 않은 숫자를 입력해야 합니다.");
		}
	}

	private void validateNumber(List<Integer> numberList) {
		if (numberList.contains(0)) {
			throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해야 합니다.");
		}
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != NUMBER_SIZE) {
			throw new IllegalArgumentException("3자리의 숫자를 입력해야 합니다.");
		}
	}

	protected Hints compareNumbers(Numbers inputNumbers) {
		Hints hints = new Hints();
		for (int i = 0; i < this.numberList.size(); i++) {
			hints.add(compareElement(i, inputNumbers.numberList));
		}
		return hints;
	}

	private HintState compareElement(int index, List<Integer> inputNumbers) {
		if (this.numberList.get(index).equals(inputNumbers.get(index))) {
			return HintState.STRIKE;
		}
		if (this.numberList.contains(inputNumbers.get(index))) {
			return HintState.BALL;
		}
		return HintState.NOTHING;
	}
}
