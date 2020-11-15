package com.test.baseball;

import java.util.List;

public class BaseballCounter {
    private final List<Integer> NUMBERS;
    private int strikeCount = 0;
    private int ballCount = 0;

    public BaseballCounter(List<Integer> numbers) {
        this.NUMBERS = numbers;
    }

    public void chekAndSetCount(int idx, int number) {
        if (NUMBERS.get(idx) == number) {
            strikeCount++;
            return;
        }

        if (NUMBERS.contains(number)) {
            ballCount++;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public boolean isFinished() {
        return strikeCount == NUMBERS.size();
    }
}
