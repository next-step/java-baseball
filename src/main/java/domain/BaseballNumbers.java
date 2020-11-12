package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description : 야구게임에서 사용되는 숫자들을 저장
 **/
public class BaseballNumbers {
    public static final int NUMBER_OF_BASEBALL_GAME = 3;
    public static final int MINIMUM_NUMBER_OF_BASEBALL_GAME = 1;
    public static final int MAXIMUM_NUMBER_OF_BASEBALL_GAME = 9;

    private List<BaseballNumber> values;

    public BaseballNumbers() {
        values = new ArrayList<>();
    }

    public BaseballNumbers(List<BaseballNumber> shuffledAndFilteredBaseballNumber) {
        validate(shuffledAndFilteredBaseballNumber);
        this.values = shuffledAndFilteredBaseballNumber;
    }


    private void validate(List<BaseballNumber> tempBaseballNumbers) {
        validateBaseballNumberSize(tempBaseballNumbers);
        validateDuplicateBaseballNumber(tempBaseballNumbers);
    }

    private void validateBaseballNumberSize(List<BaseballNumber> tempBaseballNumbers) {
        if (tempBaseballNumbers.size() != NUMBER_OF_BASEBALL_GAME)
            throw new IllegalStateException("입력가능한 숫자는 3자리 숫자입니다.");
    }

    private void validateDuplicateBaseballNumber(List<BaseballNumber> tempBaseballNumbers) {
        Set<BaseballNumber> duplicateBaseballNumberFiltered = new HashSet<>(tempBaseballNumbers);
        if (duplicateBaseballNumberFiltered.size() != tempBaseballNumbers.size())
            throw new IllegalStateException("중복된 숫자가 존재합니다.");
    }

    public List<BaseballNumber> getValues() {
        return this.values;
    }

    public int size() {
        return this.values.size();
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }
}
