package domain;

import util.DuplicateValidator;

public abstract class AbstractBaseBallNumbers implements DuplicateValidator {
    public static final int DEFAULT_MAX_SIZE = 3;
    protected BaseBallNumber[] numbers = new BaseBallNumber[DEFAULT_MAX_SIZE];

    AbstractBaseBallNumbers() {}

    abstract void setBaseBallNumbers(BaseBallNumber[] numbers);

    BaseBallNumber getBaseBallNumber(int index) {
        return numbers[index];
    }
}
