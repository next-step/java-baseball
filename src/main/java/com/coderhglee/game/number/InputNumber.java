package com.coderhglee.game.number;

import com.coderhglee.game.exception.GameException;

import java.util.List;

public interface InputNumber {
    void setInputNumber(List<GameNumber> gameNumbers) throws GameException;

    GameNumberGroups getInputNumber();
}
