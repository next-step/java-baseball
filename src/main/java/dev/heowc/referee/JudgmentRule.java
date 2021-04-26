package dev.heowc.referee;

import dev.heowc.ball.Balls;
import dev.heowc.referee.Judgment;
import dev.heowc.referee.JudgmentRuleChain;

@FunctionalInterface
public interface JudgmentRule {

    Judgment doJudge(Balls balls, Balls other, int index, JudgmentRuleChain chain);
}
