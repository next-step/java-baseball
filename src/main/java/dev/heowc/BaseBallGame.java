package dev.heowc;

import dev.heowc.ball.RandomBallsGenerator;
import dev.heowc.ball.SystemInBallsGenerator;
import dev.heowc.player.Batter;
import dev.heowc.player.Pitcher;
import dev.heowc.referee.BallRule;
import dev.heowc.referee.JudgmentReport;
import dev.heowc.referee.Referee;
import dev.heowc.referee.StrikeRule;

import java.util.Arrays;

public class BaseBallGame {

    private JudgmentReport report;
    private final Pitcher pitcher;
    private final Referee referee;

    private BaseBallGame(JudgmentReport report, Pitcher pitcher, Referee referee) {
        this.report = report;
        this.pitcher = pitcher;
        this.referee = referee;
    }

    public static BaseBallGame init() {
        final JudgmentReport report = JudgmentReport.empty();
        final Pitcher pitcher = new Pitcher(new RandomBallsGenerator());
        final Referee referee = new Referee(Arrays.asList(new StrikeRule(), new BallRule()));
        return new BaseBallGame(report, pitcher, referee);
    }

    public void start() {
        final Batter batter = new Batter(new SystemInBallsGenerator());
        report = referee.judge(pitcher.getBalls(), batter.getBalls());
        System.out.println(report.prettyHint());
    }

    public boolean isRunning() {
        return !report.isCompleted();
    }
}
