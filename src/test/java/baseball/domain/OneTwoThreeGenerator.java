package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class OneTwoThreeGenerator implements NumberGenerateStrategy {
    @Override
    public List<Integer> generate() {
        return Arrays.asList(1, 2, 3);
    }
}
