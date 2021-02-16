package domain;

public class BaseballNumber {

    private final int number;

    public BaseballNumber(String number) {
        this.number = Integer.parseInt(number);
    }

    public BaseballNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
