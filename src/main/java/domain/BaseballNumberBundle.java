package domain;

import utils.Validator;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class BaseballNumberBundle {
    public static final int BUNDLE_LENGTH = 3;
    public static final int DEFAULT_BUNDLE_NUMBER = 123;
    private final Map<BaseballNumber, Integer> numberBundle;

    public BaseballNumberBundle(int threeNumber) {
        validate(threeNumber);
        String[] splitStringNumbers = String.valueOf(threeNumber).split("");
        numberBundle = new HashMap<>();
        putStringToBundle(splitStringNumbers);
    }

    private void putStringToBundle(String[] splitStringNumbers) {
        for (String stringNumber : splitStringNumbers) {
            BaseballNumber baseballNumber = new BaseballNumber(Integer.parseInt(stringNumber));
            numberBundle.put(baseballNumber, numberBundle.size());
        }
    }

    public Map<BaseballNumber, Integer> getNumberBundle() {
        return numberBundle;
    }

    private void validate(int number) {
        Validator.threeLengthNumberValidation(number);
        Validator.duplicatedThreeNumberValidation(number);
    }

    public BaseballStatus getCompareResult(BaseballNumberBundle other){
        BaseballStatus status = new BaseballStatus();
        Map<BaseballNumber, Integer> otherNumberBundle = other.getNumberBundle();
        otherNumberBundle.keySet().stream()
                .filter(numberBundle::containsKey)
                .forEach(baseballNumber -> checkOrder(
                        status,
                        numberBundle.get(baseballNumber),
                        otherNumberBundle.get(baseballNumber)));
        return status;
    }

    private void checkOrder(BaseballStatus status, int thisOrder, int otherOrder) {
        if(thisOrder == otherOrder){
            status.increaseStrikeCount();
        }else {
            status.increaseBallCount();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumberBundle that = (BaseballNumberBundle) o;
        return Objects.equals(numberBundle, that.numberBundle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberBundle);
    }
}
