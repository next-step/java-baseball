package domain;

import utils.Validator;

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
        Validator.OneToNineNumberValidation(number);
    }
}
