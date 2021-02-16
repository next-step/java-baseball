package domain;

import java.util.*;
import java.util.stream.Collectors;

public class UserNumber {

    private static final int LENGTH_OF_USER_NUMBER = 3;
    private static final String REGEX = "";
    private final List<BaseballNumber> numbers;

    public UserNumber(String inputNumber) {
        List<String> numbersSplit = splitNumber(inputNumber);
        numbers = numbersSplit.stream().map(BaseballNumber::new).collect(Collectors.toList());
    }

    private List<String> splitNumber(String inputNumber) {
        String[] inputNumberSplit = inputNumber.split(REGEX);
        validateNumber(inputNumberSplit);
        return new ArrayList<>(Arrays.asList(inputNumberSplit));
    }

    private void validateNumber(String[] inputNumberSplit) {
        Set<String> notDuplicatedNumbers = new HashSet<>(Arrays.asList(inputNumberSplit));
        if (notDuplicatedNumbers.size() != LENGTH_OF_USER_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public List<BaseballNumber> getNumbers() {
        return numbers;
    }
}
