package baseball;

import java.util.List;

public class BallNumbersPlayerInputStrategy implements BallNumbersStrategy {

    List<String> ballNumbers;

    public BallNumbersPlayerInputStrategy(List<String> ballNumbers) {
        this.ballNumbers = ballNumbers;
    }

    @Override
    public List<String> getBallNumber() {
        return ballNumbers;
    }

}
