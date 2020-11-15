package domain;

import static domain.BaseballCodeDefinition.NUMBER_OF_DIGIT;

public class Player {
    private Number number;

    public Player(Number number) {
        this.number = number;
    }

    public GameResult result(Number userNumber) {
        return new GameResult(strike(userNumber), ball(userNumber));
    }

    private int strike(Number userNumber) {
        int strike = 0;

        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            strike += countStrike(userNumber.getDigit(i), number.getDigit(i));
        }

        return strike;
    }

    private int countStrike(int userDigit, int playerDigit) {
        if (userDigit == playerDigit) {
            return 1;
        }

        return 0;
    }

    private int ball(Number userNumber) {
        int ball = 0;

        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            ball += countBall(userNumber, i);
        }

        return ball;
    }

    private int countBall(Number userNumber, int index) {
        int userDigit = userNumber.getDigit(index);
        int playerDigit = number.getDigit(index);

        if (countStrike(userDigit, playerDigit) == 0 && number.containsDigit(userDigit)) {
            return 1;
        }

        return 0;
    }

}
