package precourse.baseball;

import static precourse.constant.BaseballGameMessage.*;
import static precourse.constant.BaseballSpecification.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baseballs {

    private static final int NO_COUNT = 0;
    private static final int COUNT = 1;
    private static final int ABSENT = -1;
    private final List<precourse.baseball.Baseball> basket;

    public Baseballs(List<precourse.baseball.Baseball> basket) {
        validateSize(basket);
        validateDuplication(basket);
        this.basket = basket;
    }

    public int countStrike(Baseballs baseballs) {
        int strike = 0;
        for (int location = 0; location < MAX_BASEBALLS.getValue(); location++) {
            strike += countIfStrike(baseballs, location);
        }

        return strike;
    }

    public int countBall(Baseballs baseballs) {
        int ball = 0;
        for (precourse.baseball.Baseball baseball : basket) {
            ball += countIfBall(baseballs, baseball);
        }

        return ball;
    }

    private int countIfStrike(Baseballs baseballs, int location) {
        precourse.baseball.Baseball baseball1 = basket.get(location);
        precourse.baseball.Baseball baseball2 = baseballs.basket.get(location);

        if (baseball1.equals(baseball2)) {
            return COUNT;
        }

        return NO_COUNT;
    }

    private int countIfBall(Baseballs baseballs, precourse.baseball.Baseball baseball) {
        int location1 = basket.indexOf(baseball);
        int location2 = baseballs.basket.indexOf(baseball);

        if (isNotExists(location1, location2) || isSameLocation(location1, location2)) {
            return NO_COUNT;
        }

        return COUNT;
    }

    private boolean isSameLocation(int baseballLocation1, int baseballLocation2) {
        return baseballLocation1 == baseballLocation2;
    }

    private boolean isNotExists(int baseballLocation1, int baseballLocation2) {
        return baseballLocation1 == ABSENT || baseballLocation2 == ABSENT;
    }

    private void validateSize(List<precourse.baseball.Baseball> basket) {
        if (basket.size() != MAX_BASEBALLS.getValue()) {
            throw new IllegalArgumentException(INVALID_ANSWER.content());
        }
    }

    private void validateDuplication(List<precourse.baseball.Baseball> basket) {
        Set<precourse.baseball.Baseball> nonDuplicateBasket = new HashSet<>(basket);
        if (nonDuplicateBasket.size() != MAX_BASEBALLS.getValue()) {
            throw new IllegalArgumentException(INVALID_ANSWER.content());
        }
    }

}
