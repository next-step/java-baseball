package baseball.domain;

import baseball.domain.strategy.BallGenerateStrategy;
import baseball.exception.BallException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ThreeBall {

    private static final int BALL_SIZE = 3;
    private static final String CONSTRUCT_ERROR_MESSAGE = "공 생성에 실패 하였습니다.";
    private static final String SIZE_ERROR_MESSAGE = "공의 사이즈가 3개가 되어야 합니다.";

    private List<BallNumber> balls;

    public ThreeBall(final BallGenerateStrategy strategy) {
        List<BallNumber> result = new ArrayList<>();

        validateStrategy(strategy);
        List<Integer> numbers = strategy.generate();

        for (Integer number : numbers) {
            result.add(new BallNumber(number));
        }

        validateSize(result);
        this.balls = Collections.unmodifiableList(result);
    }

    private void validateSize(final List<BallNumber> balls) {
        if (balls.size() != BALL_SIZE) {
            throw new BallException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateStrategy(final BallGenerateStrategy strategy) {
        if (Objects.isNull(strategy)) {
            throw new BallException(CONSTRUCT_ERROR_MESSAGE);
        }
    }

    public MatchResult compareAll(final ThreeBall target) {
        MatchResult matchResult = new MatchResult();

        for (BallNumber ball : target.balls) {
            matchResult = matchResult
                    .addMatchType(filterResultType(ball, target.balls.indexOf(ball)));
        }

        return matchResult;
    }

    private MatchType filterResultType(final BallNumber target,
                                       final int index) {
        if (this.balls.contains(target)) {
            return compareValueAndIndex(target, index);
        }

        return MatchType.NOTHING;
    }

    private MatchType compareValueAndIndex(final BallNumber target,
                                           final int index) {
        if (this.balls.indexOf(target) == index) {
            return MatchType.STRIKE;
        } else {
            return MatchType.BALL;
        }
    }

}
