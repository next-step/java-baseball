package com.coderhglee.game.number;

import java.util.List;

import com.coderhglee.game.exception.GameException;

public interface InputNumber {
	void setInputNumber(List<Number> numbers) throws GameException;

	NumberGroups getInputNumber();
}
