package baseball.service;

import baseball.domain.ThreeBall;
import baseball.domain.strategy.BallGenerateStrategy;

public class GameService {

    public ThreeBall generateGoal(BallGenerateStrategy ballStrategy) {
        return new ThreeBall(ballStrategy);
    }

}
