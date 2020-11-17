package baseball.domain;

import baseball.configuration.BaseballConfiguration;

public class GameScore {

    private int strike;
    private int ball;

    public GameScore() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isGameClear() {
        if (this.strike == BaseballConfiguration.REQUIRED_COUNT) {
            return true;
        }
        return false;
    }

    public void checkGameScore(String[] randomNumbers, String inputNumber) {

        this.strike = 0;
        this.ball = 0;

        for (int i = 0; i < randomNumbers.length; i++) {
            String num = randomNumbers[i];
            ballCheck(num, inputNumber, i);
            strikeCheck(num, inputNumber, i);
        }
    }

    private void ballCheck(String randomNumber, String inputNumber, int idx) {
        String[] inputNumbers = inputNumber.split("");
        if (inputNumber.contains(randomNumber) && !randomNumber.equals(inputNumbers[idx])) {
            this.ball++;
        }
    }

    private void strikeCheck(String randomNumber, String inputNumber, int idx) {
        String[] inputNumbers = inputNumber.split("");
        if (randomNumber.equals(inputNumbers[idx])) {
            this.strike++;
        }
    }

    public boolean isExistStrikeCount() {
        if (this.strike != 0) {
            return true;
        }
        return false;
    }

    public boolean isExistBallCount() {
        if (this.ball != 0) {
            return true;
        }
        return false;
    }


}