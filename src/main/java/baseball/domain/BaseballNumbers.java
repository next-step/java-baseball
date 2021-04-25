package baseball.domain;

import baseball.util.BaseballException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BaseballNumbers {
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int MIN_RANDOM_NUMBER = 1;
    public static final int RANDOM_NUMBER_COUNT = 3;
    private  List<String> values;

    public BaseballNumbers() {

    }
    public BaseballNumbers(List<String> values) {
        this.values = values;
    }

    public BaseballNumbers(String values) {
        this.values = Arrays.asList(values.split(""));

        validateInputIsInteger(values);
        validateInputBoundary();
        validateInputLength();
        validateDuplicateInput();
    }

    private void validateInputIsInteger(String values) {
        try {
            Integer.parseInt(values);
        } catch (NumberFormatException e) {
            throw new BaseballException.IllegalPlayerInputType();
        }
    }

    public void validateInputBoundary() {
        ArrayList<Boolean> booleans = new ArrayList<>();

        for(String value : values) {
            int parsedValue = Integer.parseInt(value);
            booleans.add(MIN_RANDOM_NUMBER <= parsedValue && parsedValue <= MAX_RANDOM_NUMBER);
        }

        if(booleans.contains(false))
            throw new BaseballException.IllegalPlayerInputBoundary();
    }

    public void validateInputLength() {
        if(values.size() != RANDOM_NUMBER_COUNT) {
            throw new BaseballException.IllegalPlayerInputLength();
        }
    }

    public void validateDuplicateInput() {
        if(values.size() != (new HashSet<String>(values).size())){
            throw new BaseballException.IllegalDuplicatePlayerInput();
        }
    }

    public List<String> getValues() {
        return this.values.subList(0, 3);
    }

    public int size() {
        return this.values.size();
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }
}
