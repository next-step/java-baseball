package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BallNumbersRandomStrategy implements BallNumbersStrategy {

    private static final int MAX_LENGTH_OF_NUMBER = 3;
    private static final Random random = new Random();

    @Override
    public Set<Integer> getBallNumber() {
        Set<Integer> ballNumbers = new HashSet<>();
        while (ballNumbers.size() < MAX_LENGTH_OF_NUMBER) {
            ballNumbers.add(random.nextInt(9) + 1);
        }
        return ballNumbers;
    }

}
