package com.coderhglee.game.number;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.coderhglee.game.GameSettingProperties;
import com.coderhglee.game.exception.GameException;


public class RandomInputNumber implements InputNumber {
	NumberGroups numberGroups;

	public RandomInputNumber() throws GameException {
		List<Number> inputNumber = makeRandomNumber(new ArrayList<>());
		setInputNumber(inputNumber);
	}

	@Override
	public void setInputNumber(List<Number> numbers) throws GameException {
		numberGroups = new NumberGroups(numbers);
	}

	@Override
	public NumberGroups getInputNumber() {
		return numberGroups;
	}

	private List<Number> makeRandomNumber(List<Number> targetNumbers) {
		while (targetNumbers.size() < GameSettingProperties.INPUT_MESSAGE_MAX_LENGTH.value) {
			addRandomNumber(targetNumbers);
		}
		return targetNumbers;
	}

	private void addRandomNumber(List<Number> targetNumbers) {
		int randomNumber = getRandomNumberFromAllowRange(
			GameSettingProperties.GAME_NUMBER_MIN_RANGE.value,
			GameSettingProperties.GAME_NUMBER_MAX_RANGE.value);
		Number randomGameNumber = Number.gameNumberMap.get(randomNumber);
		if (!targetNumbers.contains(randomGameNumber)) {
			targetNumbers.add(randomGameNumber);
			return;
		}
		makeRandomNumber(targetNumbers);
	}

	private int getRandomNumberFromAllowRange(int min, int max) {
		Random random = new SecureRandom();
		return random.nextInt(max - min) + min;
	}
}
