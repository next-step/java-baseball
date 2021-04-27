package com.bistros.game.domain.referee;

import java.util.List;

public class InningReport {

    private final long strike;
    private final long ball;

    public InningReport(List<HIT> hits) {
        strike = hits.stream().filter(c -> c == HIT.STRIKE).count();
        ball = hits.stream().filter(c -> c == HIT.BALL).count();
    }

    public long getStrike() {
        return strike;
    }

    public long getBall() {
        return ball;
    }

    public enum HIT {
        STRIKE,
        BALL,
        NOTHING
    }
}
