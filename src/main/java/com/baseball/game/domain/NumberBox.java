package com.baseball.game.domain;

public class NumberBox {
    private final static int MIN_VALUE = 1;
    private final static int MAX_VALUE = 9;

    private int index;
    private int number;

    public static NumberBox of(int index, int number) {
        return new NumberBox(index, number);
    }

    public NumberBox(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public static int getMinValue() {
        return MIN_VALUE;
    }

    public static int getMaxValue() {
        return MAX_VALUE;
    }

    public int getIndex() {
        return index;
    }

    public int getNumber() {
        return number;
    }

    public boolean equalsNumber(int number) {
        return this.number == number;
    }

}