package domain;

import common.Const;

import java.util.List;

public class BaseballPlay {

    private List<Integer> randomNumbers;
    private int strikeCount;
    private int ballCount;

    public BaseballPlay(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
        strikeCount = 0;
        ballCount   = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void play(List<Integer> inputNumbers) {
        for (int i = 0; i < Const.COMPUTER_NUMBER_SIZE; i++) {
            strike(inputNumbers.get(i), i);
            ball(inputNumbers.get(i), i);
        }
    }

    public void strike(Integer inputNumber, int idx) {
        if (randomNumbers.get(idx) == inputNumber) {
            strikeCount++;
        }
    }

    public void ball(Integer inputNumber, int idx) {
        if (randomNumbers.get(idx) != inputNumber && randomNumbers.contains(inputNumber)) {
            ballCount++;
        }
    }
}
