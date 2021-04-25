package baseball;

import java.util.*;

public class BaseballNumbers {
    private final Map<BaseballNumber, BaseballPosition> baseballNumbers;

    private BaseballNumbers(Map<BaseballNumber, BaseballPosition> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers create(List<Integer> numbers) {
        int position = 0;
        Map<BaseballNumber, BaseballPosition> baseballNumbers = new HashMap<>();
        for (Integer number : numbers) {
            baseballNumbers.put(
                    BaseballNumber.create(number),
                    BaseballPosition.create(position++)
            );
        }

        return new BaseballNumbers(baseballNumbers);
    }

    public BaseballResults compareTo(BaseballNumbers targetBaseballNumbers) {
        BaseballResults baseballResults = new BaseballResults();
        for (Map.Entry<BaseballNumber, BaseballPosition> targetEntry : targetBaseballNumbers.baseballNumbers.entrySet()) {
            Pitching pitching = compareTo(targetEntry.getKey(), targetEntry.getValue());
            baseballResults.addResult(pitching);
        }
        return baseballResults;
    }

    private Pitching compareTo(BaseballNumber targetBaseballNumber, BaseballPosition targetBaseballPosition) {
        if (!baseballNumbers.containsKey(targetBaseballNumber)) {
            return Pitching.NOTHING;
        }

        BaseballPosition baseballPosition = findBaseballPositionByBaseballNumber(targetBaseballNumber);
        if (!baseballPosition.equals(targetBaseballPosition)) {
            return Pitching.BALL;
        }

        return Pitching.STRIKE;
    }

    private BaseballPosition findBaseballPositionByBaseballNumber(BaseballNumber targetBaseballNumber) {
        return baseballNumbers.get(targetBaseballNumber);
    }

    public int size() {
        return baseballNumbers.size();
    }
}
