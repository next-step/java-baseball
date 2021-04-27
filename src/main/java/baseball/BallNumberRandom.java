package baseball;

import java.util.*;

public class BallNumberRandom {

    private static final int RANDOM_LENGTH = 3;
    private static final Random random = new Random();

    public List<Integer> getBallNumber() {
        List<Integer> ballNumbers = new ArrayList<>();
        while (ballNumbers.size() < RANDOM_LENGTH) {
            ballNumbers.add(random.nextInt(9) + 1);
        }
        return ballNumbers;
    }
}
