package baseball;

import baseball.view.InputView;

import java.util.Set;

public class BallNumbersPlayerInputStrategy implements BallNumbersStrategy {
    @Override
    public Set<Integer> getBallNumber() {
        Set<Integer> ballNumbers = InputView.setBallNumber();
        return ballNumbers;
    }

}
