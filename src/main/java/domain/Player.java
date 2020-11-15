package domain;

import static domain.BaseballCodeDefinition.NUMBER_OF_DIGIT;

public class Player {
    private Number number;

    public Player(Number number) {
        this.number = number;
    }

    public GameResult result(Number userNumber) {
        return new GameResult(strike(userNumber), ball());
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

    private int ball() {
        return 0;
    }

}
