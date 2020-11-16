package baseball.domain;

public class BaseballNumber {
    private int number;
    private int offset;

    private BaseballNumber(int number, int offset) {
        this.number = number;
        this.offset = offset;
    }

    public static BaseballNumber of(int number, int offset) {
        return new BaseballNumber(number, offset);
    }

    @Override
    public String toString() {
        return "BaseballNumber{" +
                "number=" + number +
                ", offset=" + offset +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BaseballNumber)) {
            return false;
        }
        BaseballNumber baseballNumber = (BaseballNumber) obj;
        return baseballNumber.number == number;
    }

    public int getNumber() {
        return number;
    }

    public int getOffset() {
        return offset;
    }
}
