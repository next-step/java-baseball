package domain;

import exception.OutOfRangeBBNException;
import util.RangeableValidator;

public class BaseBallNumber implements RangeableValidator {
    public static final int DEFAULT_MIN_NUMBER = 1;
    public static final int DEFAULT_MAX_NUMBER = 9;

    private int number;

    BaseBallNumber(int number) {
        isInRange(number);
        this.number = number;
    }

    public int get() {
        return this.number;
    }

    @Override
    public void isInRange(int number) {
        if(number < DEFAULT_MIN_NUMBER || number > DEFAULT_MAX_NUMBER)
            throw new OutOfRangeBBNException(String.format("입력된 수는 %d ~ %d 범위의 자연수여야합니다.", DEFAULT_MIN_NUMBER, DEFAULT_MAX_NUMBER));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseBallNumber that = (BaseBallNumber) o;

        return number == that.number;
    }
}
