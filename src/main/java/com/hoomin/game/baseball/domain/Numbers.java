package com.hoomin.game.baseball.domain;

import java.util.List;

import com.hoomin.game.baseball.enums.HintState;

public class Numbers {
	private final List<Integer> numberList;

	public Numbers(List<Integer> numberList) {
		this.numberList = numberList;
	}

	Hints compareNumbers(Numbers inputNumbers) {
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
