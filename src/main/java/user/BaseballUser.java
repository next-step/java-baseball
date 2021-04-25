package user;

import baseball.BaseballConstants;
import baseball.BaseballNumbers;

import java.util.ArrayList;
import java.util.List;

public class BaseballUser {

    public BaseballNumbers inputNumber(String userInput) {
        List<Integer> userInputIntegers = parseToIntegers(userInput);
        BaseballNumbers baseballNumbers = BaseballNumbers.create(userInputIntegers);
        validateBaseballNumberSize(baseballNumbers);
        return baseballNumbers;
    }

    private List<Integer> parseToIntegers(String userInput) {
        List<Integer> integers = new ArrayList<>();
        String[] splitNumbersAsString = userInput.split("");
        for (String numberAsString : splitNumbersAsString) {
            integers.add(parseToInteger(numberAsString));
        }
        return integers;
    }

    private Integer parseToInteger(String numberAsString) {
        try {
            return Integer.parseInt(numberAsString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("입력된 값이 숫자가 아닙니다. 오류 값: %s", numberAsString));
        }
    }

    private void validateBaseballNumberSize(BaseballNumbers baseballNumbers) {
        if (baseballNumbers.size() != BaseballConstants.BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException("입력된 숫자가 올바르지 않습니다.");
        }
    }
}
