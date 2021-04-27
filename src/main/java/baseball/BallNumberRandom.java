package baseball;

import java.util.*;

public class BallNumberRandom {

    private static final int RANDOM_LENGTH = 3;
    private static final Random random = new Random();

    public List<Integer> getBallNumber() {

        Set<Integer> set = new HashSet<>();
        while (set.size() < RANDOM_LENGTH) {
            set.add(random.nextInt(9) + 1);
        }
        List<Integer> ballNumbers = new ArrayList<>(set);

        return ballNumbers;
    }
}
