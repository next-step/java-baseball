package com.hoomin.game.baseball.domain;

import java.util.HashSet;
import java.util.List;

import com.hoomin.game.baseball.enums.HintState;

/**
 * 숫자와 관련된 비즈니스로직, 생성시 유효성 체크
 * numbers는 불변
 */
public class Numbers {
	private static final int NUMBER_SIZE = 3;
	private final List<Integer> numbers;

	public Numbers(List<Integer> numbers) {
		validateSize(numbers);
		validateNumber(numbers);
		validateDuplicate(numbers);
		this.numbers = numbers;
	}

	private void validateDuplicate(List<Integer> numbers) {
		if (numbers.size() != new HashSet<>(numbers).size()) {
			throw new IllegalArgumentException("중복되지 않은 숫자를 입력해야 합니다.");
		}
	}

	private void validateNumber(List<Integer> numbers) {
		if (numbers.contains(0)) {
			throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해야 합니다.");
		}
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != NUMBER_SIZE) {
			throw new IllegalArgumentException("3자리의 숫자를 입력해야 합니다.");
		}
	}

	public Hints compareTo(Numbers inputNumbers) {
		Hints hints = new Hints();
		for (int i = 0; i < this.numbers.size(); i++) {
			hints.add(compareElement(i, inputNumbers.numbers));
		}
		return hints;
	}

	private HintState compareElement(int index, List<Integer> inputNumbers) {
		if (this.numbers.get(index).equals(inputNumbers.get(index))) {
			return HintState.STRIKE;
		}
		if (this.numbers.contains(inputNumbers.get(index))) {
			return HintState.BALL;
		}
		return HintState.NOTHING;
	}
}
