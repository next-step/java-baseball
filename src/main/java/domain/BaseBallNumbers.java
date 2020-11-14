package domain;

import exception.DuplicatedBBNException;
import exception.OutOfSizeBBNException;

public class BaseBallNumbers extends AbstractBaseBallNumbers {
    private int bitMask;

    BaseBallNumbers() {
        this.bitMask = 0;
    }

    @Override
    final protected void setBaseBallNumbers(BaseBallNumber[] numbers) {
        if(numbers.length != BaseBallNumbers.DEFAULT_MAX_SIZE) {
            throw new OutOfSizeBBNException(String.format("입력된 수의 자리수는 [%d]이어야 합니다.", BaseBallNumbers.DEFAULT_MAX_SIZE));
        }
        for (BaseBallNumber number : numbers) {
            isDuplicatedNumber(number);
            setBit(number);
        }
        this.numbers = numbers;
    }

    @Override
    public void isDuplicatedNumber(BaseBallNumber number) {
        if(isMasked(number))
            throw new DuplicatedBBNException(String.format("중복된 수 [%d] 가 입력되었습니다.", number.get()));
    }

    boolean isMasked(BaseBallNumber number) {
        int bit = (1 << number.get());
        return (bitMask & bit) == bit;
    }

    protected void setBit(BaseBallNumber number) {
        bitMask |= (1 << number.get());
    }
}
