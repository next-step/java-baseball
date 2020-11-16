package baseball.domain;

import baseball.constants.MessageType;
import baseball.exception.InvalidNumbersException;
import baseball.util.BaseballNumberUtil;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class BaseballNumbers {
    private List<BaseballNumber> numbers;

    public BaseballNumbers() {
        this.numbers = new ArrayList<>();
    }

    public BaseballNumbers(int number) {
        validate(number);

        this.numbers = new ArrayList<>();

        List<Integer> numberList = BaseballNumberUtil.numberToListFrom(number);
        for (int n : BaseballNumberUtil.numberToListFrom(number)) {
            numbers.add(BaseballNumber.of(n, numberList.indexOf(n)));
        }
    }

    @Override
    public String toString() {
        return "BaseballNumbers{" +
                "numbers=" + numbers +
                '}';
    }

    public boolean isEmpty() {
        return numbers == null || numbers.size() == 0;
    }

    private void validate(int number) {
        validateRange(number);
        validateDuplicate(number);
    }

    private void validateDuplicate(int number) {
        String[] splits = String.valueOf(number).split("");

        LinkedHashSet<Integer> numberHashSet = new LinkedHashSet<>();

        for (String s : splits) {
            numberHashSet.add(Integer.parseInt(s));
        }
        if (numberHashSet.size() != splits.length) {
            throw new InvalidNumbersException(MessageType.INVALID_DUPLI_NUMBER);
        }
    }

    private void validateRange(int number) {
        if (number < 100 || number > 999) {
            throw new InvalidNumbersException(MessageType.INVALID_RANGE_NUMBER);
        }
    }
}
