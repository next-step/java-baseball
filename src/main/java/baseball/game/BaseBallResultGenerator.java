package baseball.game;

import baseball.util.StringUtils;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class BaseBallResultGenerator {
    public static String generateResult() {
        Set<Integer> resultSet = new LinkedHashSet<>(3);

        while (3 > resultSet.size()) {
            resultSet.add(ThreadLocalRandom.current().nextInt(1, 9));
        }

        return StringUtils.join(resultSet, "");
    }
}
