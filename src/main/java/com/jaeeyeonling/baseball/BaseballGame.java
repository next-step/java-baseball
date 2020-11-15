package com.jaeeyeonling.baseball;

import com.jaeeyeonling.baseball.ball.Balls;
import com.jaeeyeonling.baseball.ball.BallsGenerator;
import com.jaeeyeonling.baseball.ball.RandomBaseBallsGenerator;
import com.jaeeyeonling.baseball.referee.JudgeReport;
import com.jaeeyeonling.baseball.referee.Referee;

public final class BaseballGame {

    private final Balls balls;

    private final Referee referee;

    private JudgeReport report = JudgeReport.empty();

    private BaseballGame(final Balls balls,
                         final Referee referee) {
        this.balls = balls;
        this.referee = referee;
    }

    public static BaseballGame random() {
        return basic(RandomBaseBallsGenerator.INSTANCE);
    }

    public static BaseballGame basic(final BallsGenerator ballsGenerator) {
        return basic(ballsGenerator.generate());
    }

    public static BaseballGame basic(final Balls balls) {
        return of(balls, Referee.basic());
    }

    public static BaseballGame of(final Balls balls,
                                  final Referee referee) {
        return new BaseballGame(balls, referee);
    }

    public void pitch(final Balls pitchBalls) {
        report = referee.judges(balls, pitchBalls);
    }

    public boolean notComplete() {
        return !report.isComplete();
    }

    public JudgeReport getReport() {
        return report;
    }
}
