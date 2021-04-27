package kr.aterilio.nextstep.techcamp.precourse.baseball.judge;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Judgement {

    private static final int NOT_FOUND = -1;
    private static final int NOTHING = 0;
    private static final int CLEAR_STRIKE = 3;

    private int strike = 0;
    private int ball = 0;

    public Judgement(Set<Integer> game, List<Integer> inputs) {
        initCount();
        int i = 0;
        for (int number : game) {
            int input = Optional.of(inputs.get(i++))
                                .orElse(NOT_FOUND);
            judgeStrikeOrBall(game, number, input);
        }
    }

    private void initCount() {
        strike = 0;
        ball = 0;
    }

    private void judgeStrikeOrBall(Set<Integer> game, int number, int input) {
        if (number == input) {
            strike++;
            return;
        }
        if (game.contains(input)) {
            ball++;
        }
    }

    public boolean isClear() {
        return strike == CLEAR_STRIKE;
    }

    public int strike() {
        return strike;
    }

    public int ball() {
        return ball;
    }
}
