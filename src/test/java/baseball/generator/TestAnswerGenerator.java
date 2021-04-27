package baseball.generator;

import java.util.Arrays;
import java.util.List;

public class TestAnswerGenerator implements NumberGenerator {
    private static final List<Integer> baseballNumbers = Arrays.asList(1, 2, 3);

    @Override
    public List<Integer> generator() {
        return baseballNumbers;
    }
}
