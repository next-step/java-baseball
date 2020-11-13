package baseball.domain;

import java.util.*;

public class BaseballNumbers implements Iterable<BaseballNumber> {

    private List<BaseballNumber> baseballNumbers = new ArrayList<>();

    private BaseballNumbers(int ... numbers) {
        if (numbers.length != 3) {
            throw new IllegalArgumentException("3개만 입력할 수 있습니다.");
        }
        for (int number : numbers) {
            BaseballNumber baseballNumber = new BaseballNumber(number);
            validateDuplicatedNumber(baseballNumber);
            baseballNumbers.add(baseballNumber);
        }
    }

    public static BaseballNumbers of(int ... numbers) {
        return new BaseballNumbers(numbers);
    }

    public static BaseballNumbers ofUserInput(String numberLine) {
        return new BaseballNumbers(mapToNumbers(numberLine));
    }

    private static int[] mapToNumbers(String numberLine) {
        int[] result = new int[numberLine.length()];
        for (int i = 0; i < numberLine.length(); i++) {
            result[i] = Character.getNumericValue(numberLine.charAt(i));
        }
        return result;
    }

    private void validateDuplicatedNumber(BaseballNumber baseballNumber) {
        if (baseballNumbers.contains(baseballNumber)) {
            throw new IllegalArgumentException("중복된 야구번호 입니다.");
        }
    }

    List<BaseballNumber> getBaseballNumbers() {
        return baseballNumbers;
    }

    public Map<ResultType, Integer> compareBaseballNumbers(BaseballNumbers target) {
        Map<ResultType, Integer> result = new HashMap<>();
        for (BaseballNumber baseballNumber : target) {
            ResultType resultType = compareBaseballNumber(baseballNumber, target.getBaseballNumberIndex(baseballNumber));
            if (resultType == ResultType.NOTHING) {
                continue;
            }
            int count = result.getOrDefault(resultType, 0);
            result.put(resultType, count + 1);
        }
        return result;
    }

    private int getBaseballNumberIndex(BaseballNumber baseballNumber) {
        return baseballNumbers.indexOf(baseballNumber);
    }

    ResultType compareBaseballNumber(BaseballNumber baseballNumber, int index) {
        int exist = baseballNumbers.indexOf(baseballNumber);
        if (exist == -1) {
            return ResultType.NOTHING;
        }
        return exist == index ? ResultType.STRIKE : ResultType.BALL;
    }

    @Override
    public Iterator<BaseballNumber> iterator() {
        return baseballNumbers.iterator();
    }

}
