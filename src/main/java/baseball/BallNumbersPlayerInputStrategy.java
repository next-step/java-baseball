package baseball;

import java.util.List;

public class BallNumbersPlayerInputStrategy implements BallNumbersStrategy {

    List<Integer> ballNumbers;

    public BallNumbersPlayerInputStrategy(List<Integer> ballNumbers) {
        this.ballNumbers = ballNumbers;
    }

    @Override
    public List<Integer> getBallNumber() {
        return ballNumbers;
    }

}
