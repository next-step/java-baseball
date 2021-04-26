package dev.heowc.referee;

import dev.heowc.ball.Balls;
import dev.heowc.player.Player;

import java.util.List;

public final class Referee {

    private final List<JudgmentRule> judgmentRuleList;

    public Referee(List<JudgmentRule> judgmentRuleList) {
        this.judgmentRuleList = judgmentRuleList;
    }

    public JudgmentReport judge(Balls balls,
                                Balls otherBalls) {
        final JudgmentReport report = JudgmentReport.empty();
        for (int i = 0; i < Balls.SIZE; i++) {
            final JudgmentRuleChain ruleChain = JudgmentRuleChain.ofDefault(judgmentRuleList);
            report.increment(ruleChain.judge(balls, otherBalls, i));
        }
        return report;
    }
}
