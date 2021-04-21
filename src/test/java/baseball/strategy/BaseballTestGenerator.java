package baseball.strategy;

import baseball.domain.BallNumber;
import baseball.domain.BallNumbers;
import baseball.domain.strategy.BaseballGenerator;

import java.util.List;

public class BaseballTestGenerator implements BaseballGenerator {
    private List<BallNumber> ballNumbers;

    @Override
    public BallNumbers generate() {
        return new BallNumbers(this.ballNumbers);
    }

    public void setBallNumbers(List<BallNumber> ballNumbers) {
        this.ballNumbers = ballNumbers;

    }
}
