package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {
    private final Set<BaseballNumber> baseballNumbers;

    private BaseballNumbers(Set<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers create(List<Integer> numbers) {
        int position = 0;
        Set<BaseballNumber> baseballNumbers = new HashSet<>();
        for (Integer number : numbers) {
            baseballNumbers.add(BaseballNumber.createByNumberAndPosition(number, position));
        }

        return new BaseballNumbers(baseballNumbers);
    }

    public int size() {
        return baseballNumbers.size();
    }
}
