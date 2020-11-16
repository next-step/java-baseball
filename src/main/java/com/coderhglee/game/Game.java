package com.coderhglee.game;

import com.coderhglee.game.number.InputNumber;


public interface Game<T> {
	void gameProcess(InputNumber inputNumber);

	String getGameResultMessage();

	T getGameStatus();
}
