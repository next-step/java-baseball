package baseball.domain;

import baseball.util.ArrayUtils;
import baseball.validator.InputNumbersValidator;
import baseball.validator.Validatable;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static baseball.validator.InputNumbersValidator.INVALID_INPUT_NUMBERS_MESSAGE;

public class InputNumbers {
    private static final Validatable<Set<GameNumber>> validator = new InputNumbersValidator();
    private final List<GameNumber> inputNumbers;

    public InputNumbers(Set<GameNumber> inputNumbers) {
        validator.validate(inputNumbers);
        this.inputNumbers = new ArrayList<>(inputNumbers);
    }

    public static InputNumbers from(char[] inputChars) {
        if (ArrayUtils.isEmpty(inputChars)) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBERS_MESSAGE);
        }

        Set<GameNumber> inputNumbers = new LinkedHashSet<>();
        for (char curChar : inputChars) {
            inputNumbers.add(GameNumber.getInstance(curChar - '0'));
        }
        return new InputNumbers(inputNumbers);
    }

    public int size() {
        return inputNumbers.size();
    }

    public GameNumber get(int index) {
        return inputNumbers.get(index);
    }
}
