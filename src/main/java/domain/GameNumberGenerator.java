package domain;

import utils.NumberUtils;

import java.util.*;

public class GameNumberGenerator implements NumberGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public List<Number> generate() {
        Set<Integer> set = new HashSet<>();

        while (set.size() < 3) {
            set.add(RANDOM.nextInt(8) + 1); // 1 ~ 9
        }

        return NumberUtils.toList(set);
    }
}
