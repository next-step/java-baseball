package com.coderhglee.game.number;

import com.coderhglee.game.GameSettingProperties;
import com.coderhglee.game.exception.ContainSameNumberException;
import com.coderhglee.game.exception.ExceedAllowLengthException;

import java.util.ArrayList;
import java.util.List;

public class GameNumberGroups {
    private final List<GameNumber> gameNumbers;

    public GameNumberGroups(List<GameNumber> inputGameNumbers) throws ExceedAllowLengthException, ContainSameNumberException {
        gameNumbers = new ArrayList<>();
        isExceedAllowMaxLength(inputGameNumbers);
        setGameNumbersFromInputGameNumbers(inputGameNumbers);
    }

    private void isExceedAllowMaxLength(List<GameNumber> inputGameNumbers) throws ExceedAllowLengthException {
        if (inputGameNumbers.size() != GameSettingProperties.INPUT_MESSAGE_MAX_LENGTH.value) {
            throw new ExceedAllowLengthException();
        }
    }

    private void setGameNumbersFromInputGameNumbers(List<GameNumber> inputGameNumbers) throws ContainSameNumberException {
        for (GameNumber inputGameNumber : inputGameNumbers) {
            checkContainSingleGameNumber(inputGameNumber);
            this.gameNumbers.add(inputGameNumber);
        }
    }

    private void checkContainSingleGameNumber(GameNumber inputGameNumber) throws ContainSameNumberException {
        if(this.gameNumbers.contains(inputGameNumber))
            throw new ContainSameNumberException();
    }


    public List<GameNumber> getGameNumbers() {
        return gameNumbers;
    }

    public GameNumber getGameNumberByIndex(int index) {
        return gameNumbers.get(index);
    }

}
