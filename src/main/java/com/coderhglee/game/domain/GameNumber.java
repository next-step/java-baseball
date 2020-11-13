package com.coderhglee.game.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

enum GameNumber {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    public static final Map<Integer, GameNumber> gameNumberMap = Collections.unmodifiableMap(getBaseballNumberMap());

    private final int number;

    GameNumber(int value) {
        this.number = value;
    }

    int getNumberValue() {
        return number;
    }

    private static Map<Integer, GameNumber> getBaseballNumberMap() {
        Map<Integer, GameNumber> newMap = new HashMap<>();
        for (GameNumber gameNumber : values()) {
            newMap.put(gameNumber.getNumberValue(), gameNumber);
        }
        return newMap;
    }
}
