package com.coderhglee.game.domain;

import com.coderhglee.game.exception.ExceedAllowLengthException;

import java.util.ArrayList;
import java.util.List;

public class GameNumberGroups {
    public static final int MESSAGE_ALLOW_LENGTH_MAX = 3;
    private List<GameNumber> gameNumbers;

    public GameNumberGroups(List<GameNumber> gameNumbers) throws ExceedAllowLengthException {
        if (gameNumbers.size() != MESSAGE_ALLOW_LENGTH_MAX) {
            throw new ExceedAllowLengthException();
        }
        this.gameNumbers = gameNumbers;
    }

    public boolean isContains(GameNumberGroups gameNumbers) {
        return this.gameNumbers.containsAll(gameNumbers.gameNumbers);
    }

    public List<GameNumber> getGameNumbers() {
        return gameNumbers;
    }

    public GameNumber getGameNumberByIndex(int index) {
        return gameNumbers.get(index);
    }
}
