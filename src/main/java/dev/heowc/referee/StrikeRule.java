package dev.heowc.referee;

import dev.heowc.ball.Balls;
import dev.heowc.referee.Judgment;
import dev.heowc.referee.JudgmentRuleChain;

public final class StrikeRule implements JudgmentRule {

    @Override
    public Judgment doJudge(Balls balls, Balls other, int index, JudgmentRuleChain chain) {
        if (balls.match(other, index)) {
            return Judgment.STRIKE;
        }

        return chain.judge(balls, other, index);
    }
}
