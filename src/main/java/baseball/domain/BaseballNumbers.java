package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class BaseballNumbers {

    private static final int SIZE = 3;

    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validate(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers == null) {
            throw new IllegalArgumentException("숫자 정보를 입력해 주세요.");
        }
        if (baseballNumbers.size() != SIZE) {
            throw new IllegalArgumentException("숫자는 " + SIZE + " 개로 이루어져야 합니다.");
        }
        if (baseballNumbers.size() > calculateDistinctSize(baseballNumbers)) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다. 입력값을 확인해 주세요.");
        }
    }

    private int calculateDistinctSize(List<BaseballNumber> baseballNumbers) {
        return new HashSet<>(baseballNumbers).size();
    }
}
