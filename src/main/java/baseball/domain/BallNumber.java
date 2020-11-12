package baseball.domain;

public class BallNumber {

    private int number;

    public BallNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number <= 0 || number > 9) {
            throw new IllegalArgumentException();
        }
    }
}
