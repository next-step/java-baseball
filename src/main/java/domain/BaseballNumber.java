package domain;

public class BaseballNumber {

    private final int number;

    public BaseballNumber(String number) {
        this.number = Integer.parseInt(number);
        validateNumber();
    }

    public BaseballNumber(int number) {
        this.number = number;
        validateNumber();
    }

    private void validateNumber() {
        if (number == 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
