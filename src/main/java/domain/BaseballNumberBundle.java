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
        int strike = 0;
        int ball = 0;
        for (BaseballNumber baseballNumber: other.getNumberBundle().keySet()){
            if(numberBundle.containsKey(baseballNumber)){
                int thisOrder = numberBundle.get(baseballNumber);
                int otherOrder = other.getNumberBundle().get(baseballNumber);
                if(thisOrder == otherOrder){
                    strike += 1;
                }else {
                    ball += 1;
                }
            }
        }
        return new BaseballStatus(strike, ball);
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
