package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.ball.Balls;

public final class Referee {

    private final Reader reader;

    private Referee(final Reader reader) {
        this.reader = reader;
    }

    public static Referee basic() {
        return of(Reader.basic());
    }

    public static Referee of(final Reader reader) {
        return new Referee(reader);
    }

    public JudgeReport judges(final Balls balls,
                              final Balls other) {
        final var report = JudgeReport.empty();
        for (var i = 0; i < Balls.SIZE; i++) {
            report.increment(reader.readout(balls, other, i));
        }

        return report;
    }
}
