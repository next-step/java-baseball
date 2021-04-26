package dev.heowc.referee;

import dev.heowc.ball.Ball;
import dev.heowc.ball.Balls;

public final class BallRule implements JudgmentRule {

    @Override
    public Judgment doJudge(Balls balls, Balls other, int index, JudgmentRuleChain chain) {
        final Ball ball = other.get(index);
        final int searchedIndex = balls.indexOf(ball);
        if (searchedIndex > -1 && searchedIndex != index) {
            return Judgment.BALL;
        }
        return chain.judge(balls, other, index);
    }
}
