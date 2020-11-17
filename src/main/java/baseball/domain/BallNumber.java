package baseball.domain;

import java.util.List;

public class BallNumber {

    private List<String> ballNumber;

    private BallNumber() {
    }

    public BallNumber(BallNumbersStrategy ballNumbersStrategy) {
        this.ballNumber = ballNumbersStrategy.getBallNumber();
    }

    // to Test
    public List<String> getBallNumber() {
        return ballNumber;
    }

    @Override
    public String toString() {
        return "BallNumber{" +
                "ballNumber=" + ballNumber +
                '}';
    }
}
