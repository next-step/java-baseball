package baseball;

import java.util.*;

public class BallNumbersRandomStrategy implements BallNumbersStrategy {

    private static final int MAX_LENGTH_OF_NUMBER = 3;
    private static final Random random = new Random();
    private static List<String> ballNumbers;

    public BallNumbersRandomStrategy(List<String> ballNumbers) {
        if (!ballNumbers.isEmpty()) {
            this.ballNumbers = ballNumbers;
            return;
        }
        Set<String> ballNumbersSet = new HashSet<>();
        while (ballNumbersSet.size() < MAX_LENGTH_OF_NUMBER) {
            ballNumbersSet.add(String.valueOf(random.nextInt(9) + 1));
        }
        this.ballNumbers = new ArrayList<>(ballNumbersSet);
    }

    @Override
    public List<String> getBallNumber() {
        return ballNumbers;
    }

}
