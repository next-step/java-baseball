package baseballgame.number;

import java.util.HashSet;
import java.util.List;

public class InputNumber implements BaseballNumber {

    private final List<String> number;

    public InputNumber(List<String> number) throws IllegalArgumentException {
        this.number = number;
        validate(number);
    }

    private void validate(List<String> input) throws IllegalArgumentException {
        isNumber(input);
        isZeroNotIncluded(input);
        isValidSize(input);
        isDifferentFromEachOther(input);
    }

    private void isNumber(List<String> input) throws IllegalArgumentException {
        for (String number : input) {
            Integer.parseInt(number);
        }
    }

    private void isZeroNotIncluded(List<String> input) throws IllegalArgumentException {
        if (input.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidSize(List<String> input) throws IllegalArgumentException {
        if(input.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void isDifferentFromEachOther(List<String> input) throws IllegalArgumentException {
        HashSet<String> diffChecker= new HashSet<>(input);
        if (diffChecker.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<String> getNumber() {
        return number;
    }
}
