import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

    private static final int NUMBERS_REQUIRED_SIZE = 3;

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Numbers(String numbersString) {
        validate(numbersString);
        this.numbers = convertStringToCollectionOfIntegers(numbersString);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() < NUMBERS_REQUIRED_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_ENOUGH_ELEMENTS.toString());
        }
        StringBuilder numbersString = new StringBuilder();
        for (int num : numbers) {
            numbersString.append(num);
        }
        validate(numbersString.toString());
    }

    private void validate(String numbersString) {
        if (!isNumeric(numbersString)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_A_NUMBER.toString());
        }
        if (numbersString.length() != NUMBERS_REQUIRED_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_THREE_DIGITS_NUMBER.toString());
        }
        Set<Integer> argNumbers = new LinkedHashSet<>();
        for (int i = 0; i < numbersString.length(); i++) {
            String digitString = numbersString.substring(i, i + 1);
            Integer digit = Integer.valueOf(digitString);
            if (digit == 0) {
                throw new IllegalArgumentException(ExceptionMessage.ZERO_INCLUDED.toString());
            }
            if (argNumbers.contains(digit)) {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_DIGITS.toString());
            }
            argNumbers.add(digit);
        }
    }

    private boolean isNumeric(String numericFormatString) {
        if (numericFormatString == null) {
            return false;
        }
        try {
            Double.parseDouble(numericFormatString);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private List<Integer> convertStringToCollectionOfIntegers(String numbersString) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersString.length(); i++) {
            numbers.add(Integer.valueOf(numbersString.substring(i, i + 1)));
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
