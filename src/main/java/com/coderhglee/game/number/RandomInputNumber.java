package com.coderhglee.game.number;

import com.coderhglee.game.GameSettingNumbers;
import com.coderhglee.game.exception.GameException;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInputNumber implements InputNumber {
    GameNumberGroups gameNumberGroups;

    public RandomInputNumber() throws GameException {
        List<GameNumber> inputNumber = makeRandomNumber(new ArrayList<>());
        setInputNumber(inputNumber);
    }

    @Override
    public void setInputNumber(List<GameNumber> gameNumbers) throws GameException {
        gameNumberGroups = new GameNumberGroups(gameNumbers);
    }

    @Override
    public GameNumberGroups getInputNumber() {
        return gameNumberGroups;
    }

    private List<GameNumber> makeRandomNumber(List<GameNumber> targetNumbers) {
        while (targetNumbers.size() < GameSettingNumbers.INPUT_MESSAGE_MAX_LENGTH.value) {
            addRandomNumber(targetNumbers);
        }
        return targetNumbers;
    }

    private void addRandomNumber(List<GameNumber> targetNumbers) {
        int randomNumber = getRandomNumberFromAllowRange(GameSettingNumbers.GAME_NUMBER_MIN_RANGE.value, GameSettingNumbers.GAME_NUMBER_MAX_RANGE.value);
        GameNumber randomGameNumber = GameNumber.gameNumberMap.get(randomNumber);
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
