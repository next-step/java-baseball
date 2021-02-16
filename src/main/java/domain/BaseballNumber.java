package domain;

import utils.Validator;

import java.util.Objects;

public class BaseballNumber {
    private final int number;

    public BaseballNumber(int number){
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        Validator.oneToNineNumberValidation(number);
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
}
