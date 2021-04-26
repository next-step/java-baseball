package baseball;

import static constant.BaseballSpecification.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Baseballs {

    private static final int NO_COUNT = 0;
    private static final int COUNT = 1;
    private static final int ABSENT = -1;
    private final List<Baseball> basket;

    public Baseballs(List<Baseball> basket) {
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
        for (Baseball baseball : basket) {
            ball += countIfBall(baseballs, baseball);
        }

        return ball;
    }

    private int countIfStrike(Baseballs baseballs, int location) {
        Baseball baseball1 = basket.get(location);
        Baseball baseball2 = baseballs.basket.get(location);

        if (baseball1.equals(baseball2)) {
            return COUNT;
        }

        return NO_COUNT;
    }

    private int countIfBall(Baseballs baseballs, Baseball baseball) {
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

    private void validateSize(List<Baseball> basket) {
        if (basket.size() != MAX_BASEBALLS.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Baseball> basket) {
        Set<Baseball> nonDuplicateBasket = new HashSet<>(basket);
        if (nonDuplicateBasket.size() != MAX_BASEBALLS.getValue()) {
            throw new IllegalArgumentException();
        }
    }

}
