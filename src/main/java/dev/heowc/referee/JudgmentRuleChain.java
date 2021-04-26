package dev.heowc.referee;

import dev.heowc.ball.Balls;

import java.util.List;

@FunctionalInterface
interface JudgmentRuleChain {

    static JudgmentRuleChain ofDefault(List<JudgmentRule> judgmentRuleList) {
        return new DefaultJudgmentRuleChain(judgmentRuleList);
    }

    Judgment judge(Balls balls, Balls other, int index);
}
