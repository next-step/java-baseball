package domain;

import utils.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumberBundle {
    private final List<BaseballNumber> numberBundle;

    public BaseballNumberBundle(int threeNumber) {
        validate(threeNumber);
        String[] splitStringNumbers = String.valueOf(threeNumber).split("");
        this.numberBundle = Arrays.stream(splitStringNumbers)
                .map(Integer::parseInt)
                .map(BaseballNumber::new)
                .collect(Collectors.toList());
    }

    public List<BaseballNumber> getNumberBundle() {
        return numberBundle;
    }

    private void validate(int number) {
        Validator.threeLengthNumberValidation(number);
        Validator.duplicatedThreeNumberValidation(number);
    }
}
