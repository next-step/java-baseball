package baseball.service;

import baseball.domain.MatchResult;
import baseball.domain.ThreeBall;
import baseball.domain.strategy.BallGenerateStrategy;

import java.util.List;

public class GameService {

    public ThreeBall generateGoal(BallGenerateStrategy ballStrategy) {
        return new ThreeBall(ballStrategy);
    }

    public MatchResult compareGoal(final ThreeBall goal, List<Integer> userInput) {
        ThreeBall userBall = new ThreeBall(userInput);
        return goal.compareAll(userBall);
    }

}
