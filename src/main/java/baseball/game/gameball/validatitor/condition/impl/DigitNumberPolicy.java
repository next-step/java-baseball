package baseball.game.gameball.validatitor.condition.impl;

import baseball.game.gameball.GameBall;
import baseball.game.gameball.validatitor.condition.ConditionPolicy;

// 유효성 검증 - 자릿수
public class DigitNumberPolicy implements ConditionPolicy {

    @Override
    public boolean isSatisfied(String inputString) {
        return inputString.length() == GameBall.Policy.DIGIT_NUMBER;
    }
}
