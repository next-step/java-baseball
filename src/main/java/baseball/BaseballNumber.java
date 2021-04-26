package baseball;

import java.util.Objects;

public class BaseballNumber {

    private static final int MAX_INPUT_VALUE = 9;
    private static final int MIN_INPUT_VALUE = 1;

    private int number;

    public BaseballNumber(int number){
        checkNumberRange(number);
        this.number = number;
    }

    private void checkNumberRange(int number){
        if(MIN_INPUT_VALUE > number || number > MAX_INPUT_VALUE ){
            throw new IllegalArgumentException("숫자의 범위는 1 ~ 9 사이로 이루어져야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "BaseballNumber{" +
                "number=" + number +
                '}';
    }
}
