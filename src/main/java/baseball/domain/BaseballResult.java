package baseball.domain;

public class BaseballResult {
    private int ball;
    private int strike;
    private BaseballNumbers numbers;
    private BaseballNumbers targetNumbers;

    public BaseballResult() {
        this.ball = 0;
        this.strike = 0;
    }

    public BaseballResult(BaseballNumbers numbers, BaseballNumbers targetNumbers) {
        this.numbers = numbers;
        this.targetNumbers = targetNumbers;
        this.ball = 0;
        this.strike = 0;

        check();
    }

    private void check() {
        for (int i = 0; i < numbers.size(); i++) {
            checkBall(numbers.getNumbers().get(i));
            checkStrike(numbers.getNumbers().get(i), i);
        }
    }

    private void checkBall(BaseballNumber number) {
        if (targetNumbers.contains(number)) {
            ball++;
        }
    }

    private void checkStrike(BaseballNumber number, int index) {
        if (targetNumbers.getNumbers().get(index).equals(number)) {
            strike++;
            ball--;
        }
    }

    public boolean isExistStrike() {
        return strike != 0;
    }

    public boolean isExistBall() {
        return ball != 0;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean isExactSame() {
        return strike == 3;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
}
