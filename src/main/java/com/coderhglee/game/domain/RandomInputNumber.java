package com.coderhglee.game.domain;

import com.coderhglee.game.exception.GameException;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInputNumber implements InputNumber {
    GameNumberGroups gameNumberGroups;

    public RandomInputNumber() throws GameException {
        List<GameNumber> inputNumber = makeRandomNumber(new ArrayList<>(), GameNumberGroups.MESSAGE_ALLOW_LENGTH_MAX);
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

    private List<GameNumber> makeRandomNumber(List<GameNumber> targetNumbers, int length) {
        while (targetNumbers.size() < length) {
            addRandomNumber(targetNumbers, length);
        }
        return targetNumbers;
    }

    private void addRandomNumber(List<GameNumber> targetNumbers, int length) {
        GameNumber randomGameNumber = GameNumber.gameNumberMap.get(getRandomNumberFromAllowRange(1, 10));
        if (!targetNumbers.contains(randomGameNumber)) {
            targetNumbers.add(randomGameNumber);
            return;
        }
        makeRandomNumber(targetNumbers, length);
    }

    private int getRandomNumberFromAllowRange(int min, int max) {
        Random random = new SecureRandom();
        return random.nextInt(max - min) + min;
    }
}
