package baseball;

import java.util.Set;

public class BallNumber {

    // to Test
    public Set<Integer> getBallNumber() {
        return ballNumber;
    }

    private Set<Integer> ballNumber;

    private BallNumber() {
    }

    public BallNumber(BallNumbersStrategy numbersStrategy) {
        this.ballNumber = numbersStrategy.getBallNumber();
    }

    @Override
    public String toString() {
        return "BallNumber{" +
                "ballNumber=" + ballNumber +
                '}';
    }
}
