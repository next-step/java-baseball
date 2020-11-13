package baseball;

import java.util.ArrayList;
import java.util.List;

class BaseballNumbers {

    private List<BaseballNumber> baseballNumbers = new ArrayList<>();

    BaseballNumbers(int ... numbers) {
        if (numbers.length != 3) {
            throw new IllegalArgumentException("3개만 입력할 수 있습니다.");
        }
        for (int number: numbers) {
            BaseballNumber baseballNumber = new BaseballNumber(number);
            validateDuplicatedNumber(baseballNumber);
            baseballNumbers.add(baseballNumber);
        }
    }

    private void validateDuplicatedNumber(BaseballNumber baseballNumber) {
        if (baseballNumbers.contains(baseballNumber)) {
            throw new IllegalArgumentException("중복된 야구번호 입니다.");
        }
    }

    List<BaseballNumber> getBaseballNumbers() {
        return baseballNumbers;
    }

    ResultType compareBaseballNumber(BaseballNumber baseballNumber, int index) {
        int exist = baseballNumbers.indexOf(baseballNumber);
        if (exist == -1) {
            return ResultType.NOTHING;
        }
        return exist == index ? ResultType.STRIKE : ResultType.BALL;
    }

}
