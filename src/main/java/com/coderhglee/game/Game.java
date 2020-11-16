package com.coderhglee.game;

import com.coderhglee.game.exception.GameException;
import com.coderhglee.game.number.InputNumber;


public interface Game<T> {
    void gameProcess(InputNumber inputNumber) throws GameException;

    String getGameResultMessage();

    T getGameStatus();
}
