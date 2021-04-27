package com.bistros.game.domain.referee;

import com.bistros.game.domain.ball.BallNumbers;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InningReport {

    private final long strike;
    private final long ball;
    private final long hit;

    public InningReport(List<HIT> hits) {
        strike = hits.stream().filter(c -> c == HIT.STRIKE).count();
        ball = hits.stream().filter(c -> c == HIT.BALL).count();
        hit = strike + ball;
    }

    public long getStrike() {
        return strike;
    }

    public long getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike + ball == 0;
    }

    public boolean isSuccessGame() {
        return strike == BallNumbers.LENGTH;
    }


    public String getHint() {
        if (isNothing()) {
            return HIT.NOTHING.hint(hit);
        }
        return Stream.of(HIT.STRIKE.hint(strike), HIT.BALL.hint(ball))
            .filter(c -> !c.isEmpty())
            .collect(Collectors.joining(" "));
    }

    public enum HIT {
        STRIKE("%d 스트라이크", (c) -> c > 0),
        BALL("%d 볼", (c) -> c > 0),
        NOTHING("낫싱", (c) -> true);


        private final String description;
        private final Predicate<Long> predicate;

        HIT(String description, Predicate<Long> predicate) {
            this.description = description;
            this.predicate = predicate;
        }

        public String hint(long count) {
            if (predicate.test(count)) {
                return String.format(this.description, count);
            }
            return "";
        }
    }
}
