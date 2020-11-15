package baseball;

import java.util.*;

public class BallNumbersRandomStrategy implements BallNumbersStrategy {

    private static final int MAX_LENGTH_OF_NUMBER = 3;
    private static final Random random = new Random();
    private static List<Integer> ballNumbers;

    public BallNumbersRandomStrategy(List<Integer> ballNumbers) {
        if(!ballNumbers.isEmpty()) {
            this.ballNumbers = ballNumbers;
            return;
        }
        Set<Integer> ballNumbersSet = new HashSet<>();
        while (ballNumbersSet.size() < MAX_LENGTH_OF_NUMBER) {
            ballNumbersSet.add(random.nextInt(9) + 1);
        }
        this.ballNumbers = new ArrayList<>(ballNumbersSet);
    }

    @Override
    public List<Integer> getBallNumber() {
        return ballNumbers;
    }

}
