package com.coderhglee.game.number;

import java.util.ArrayList;
import java.util.List;

import com.coderhglee.game.GameSettingProperties;
import com.coderhglee.game.exception.ContainSameNumberException;
import com.coderhglee.game.exception.ExceedAllowLengthException;


public class NumberGroups {
	private final List<Number> numbers;

	public NumberGroups(List<Number> inputNumbers)
		throws ExceedAllowLengthException, ContainSameNumberException {
		numbers = new ArrayList<>();
		isExceedAllowMaxLength(inputNumbers);
		setGameNumbersFromInputGameNumbers(inputNumbers);
	}

	private void isExceedAllowMaxLength(List<Number> inputNumbers) throws ExceedAllowLengthException {
		if (inputNumbers.size() != GameSettingProperties.INPUT_MESSAGE_MAX_LENGTH.value) {
			throw new ExceedAllowLengthException();
		}
	}

	private void setGameNumbersFromInputGameNumbers(List<Number> inputNumbers)
		throws ContainSameNumberException {
		for (Number inputNumber : inputNumbers) {
			checkContainSingleGameNumber(inputNumber);
			this.numbers.add(inputNumber);
		}
	}

	private void checkContainSingleGameNumber(Number inputNumber) throws ContainSameNumberException {
		if (this.numbers.contains(inputNumber)) {
			throw new ContainSameNumberException();
		}
	}


	public List<Number> getGameNumbers() {
		return numbers;
	}

	public Number getGameNumberByIndex(int index) {
		return numbers.get(index);
	}

}
