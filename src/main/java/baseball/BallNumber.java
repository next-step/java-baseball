package baseball;

import java.util.List;

public class BallNumber {

    // to Test
    public List<Integer> getBallNumber() {
        return ballNumber;
    }

    private List<Integer> ballNumber;

    private BallNumber() {
    }

    public BallNumber(BallNumbersStrategy ballNumbersStrategy) {
        this.ballNumber = ballNumbersStrategy.getBallNumber();
    }

    @Override
    public String toString() {
        return "BallNumber{" +
                "ballNumber=" + ballNumber +
                '}';
    }
}
