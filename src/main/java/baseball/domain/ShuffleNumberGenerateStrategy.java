package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleNumberGenerateStrategy implements NumberGenerateStrategy {
    @Override
    public List<Integer> generateNumbers() {
        List<Integer> baseballNumbers = new ArrayList<>();
        for (int i = BaseballNumber.MIN_NUMBER; i <= BaseballNumber.MAX_NUMBER; i++) {
            baseballNumbers.add(i);
        }
        Collections.shuffle(baseballNumbers);
        return baseballNumbers.subList(BaseballNumbers.MIN_INDEX, BaseballNumbers.SIZE);
    }
}
