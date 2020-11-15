package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.ball.Balls;

public interface JudgeRule {

    boolean judges(Balls balls, Balls other, int index);
}
