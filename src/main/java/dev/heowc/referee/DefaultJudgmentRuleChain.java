package dev.heowc.referee;

import dev.heowc.ball.Balls;

import java.util.List;

final class DefaultJudgmentRuleChain implements JudgmentRuleChain {

    private final List<JudgmentRule> judgmentRules;
    private int position = 0;

    DefaultJudgmentRuleChain(List<JudgmentRule> judgmentRules) {
        this.judgmentRules = judgmentRules;
    }

    @Override
    public Judgment judge(Balls balls, Balls other, int index) {
        if (position < judgmentRules.size()) {
            return judgmentRules.get(position++).doJudge(balls, other, index, this);
        }

        return Judgment.MISS;
    }
}
