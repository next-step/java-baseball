package com.coderhglee.game.number;

import java.util.ArrayList;
import java.util.List;

import com.coderhglee.game.exception.GameException;
import com.coderhglee.game.exception.NotAllowValueException;


public class UserInputNumber implements InputNumber {
	NumberGroups numberGroups;

	public UserInputNumber(String value) throws GameException {
		setInputNumber(makeInputNumber(value));

	}

	@Override
	public void setInputNumber(List<Number> numbers) throws GameException {
		numberGroups = new NumberGroups(numbers);
	}

	@Override
	public NumberGroups getInputNumber() {
		return numberGroups;
	}

	public List<Number> makeInputNumber(String value) throws NotAllowValueException {
		List<Number> numbers = new ArrayList<>();
		for (String str : value.split("")) {
			Number randomNumber = Number.gameNumberMap.get(parseInteger(str));
			numbers.add(randomNumber);
		}
		return numbers;
	}

	private Integer parseInteger(String str) throws NotAllowValueException {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException numberFormatException) {
			throw new NotAllowValueException();
		}
	}

}
