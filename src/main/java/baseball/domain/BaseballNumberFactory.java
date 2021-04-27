package baseball.domain;

import common.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseballNumberFactory {

    private static final String STRING_INPUT_DELIMITER = "";
    private static final String MESSAGE_NON_INPUT = "숫자 정보를 입력해 주세요.";

    public List<BaseballNumber> generateBaseballNumbers(String numbers) {
        validate(numbers);
        List<Integer> baseballNumbers = new ArrayList<>();
        for (String number : numbers.split(STRING_INPUT_DELIMITER)) {
            baseballNumbers.add(toNumber(number));
        }
        return generateBaseballNumbers(baseballNumbers);
    }

    private void validate(String baseballNumbers) {
        if (StringUtils.isBlank(baseballNumbers)) {
            throw new IllegalArgumentException(MESSAGE_NON_INPUT);
        }
    }

    private Integer toNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public List<BaseballNumber> generateBaseballNumbers(NumberGenerateStrategy numberGenerateStrategy) {
        validate(numberGenerateStrategy);
        return generateBaseballNumbers(numberGenerateStrategy.generateNumbers());
    }

    private void validate(NumberGenerateStrategy shuffleNumberGenerateStrategy) {
        if (shuffleNumberGenerateStrategy == null) {
            throw new IllegalArgumentException("숫자 생성 전략을 입력해 주세요.");
        }
    }

    private List<BaseballNumber> generateBaseballNumbers(List<Integer> numbers) {
        validate(numbers);
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            baseballNumbers.add(new BaseballNumber(number));
        }
        return baseballNumbers;
    }

    private static void validate(List<Integer> baseballNumbers) {
        if (baseballNumbers == null) {
            throw new IllegalArgumentException(MESSAGE_NON_INPUT);
        }
        if (baseballNumbers.size() != BaseballNumbers.SIZE) {
            throw new IllegalArgumentException("숫자는 " + BaseballNumbers.SIZE + " 개로 이루어져야 합니다.");
        }
        if (baseballNumbers.size() > calculateDistinctSize(baseballNumbers)) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다. 입력값을 확인해 주세요.");
        }
    }

    private static int calculateDistinctSize(List<?> baseballNumbers) {
        return new HashSet<>(baseballNumbers).size();
    }
}
