package com.coderhglee.game.domain;

import com.coderhglee.game.exception.GameException;
import com.coderhglee.game.exception.NotAllowValueException;

import java.util.ArrayList;
import java.util.List;

public class UserInputNumber implements InputNumber {
    GameNumberGroups gameNumberGroups;

    public UserInputNumber(String value) throws GameException {
        setInputNumber(makeInputNumber(value));

    }

    @Override
    public void setInputNumber(List<GameNumber> gameNumbers) throws GameException {
        gameNumberGroups = new GameNumberGroups(gameNumbers);
    }

    @Override
    public GameNumberGroups getInputNumber() {
        return gameNumberGroups;
    }

    public List<GameNumber> makeInputNumber(String value) throws NotAllowValueException {
        List<GameNumber> gameNumbers = new ArrayList<>();
        for (String str : value.split("")) {
            GameNumber randomGameNumber = GameNumber.gameNumberMap.get(parseInteger(str));
            gameNumbers.add(randomGameNumber);
        }
        return gameNumbers;
    }

    private Integer parseInteger(String str) throws NotAllowValueException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException numberFormatException) {
            throw new NotAllowValueException();
        }
    }

}
