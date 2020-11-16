package baseball.game;

import baseball.util.StringUtils;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class BaseBallValueGenerator {
    public static String generateValue() {
        Set<Integer> valueSet = new LinkedHashSet<>(3);

        while (3 > valueSet.size()) {
            valueSet.add(ThreadLocalRandom.current().nextInt(1, 9));
        }

        return StringUtils.join(valueSet, "");
    }
}
