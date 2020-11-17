package util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NumberUtil {

    private NumberUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Integer> generate() {
        final SecureRandom random = new SecureRandom();
        Set<Integer> answerList = new LinkedHashSet<>();
        while (answerList.size() < 3) {
            answerList.add(random.nextInt(9) + 1);
        }

        return new ArrayList<>(answerList);
    }
}
