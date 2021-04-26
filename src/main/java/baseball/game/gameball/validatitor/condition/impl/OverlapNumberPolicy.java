package baseball.game.gameball.validatitor.condition.impl;

import baseball.game.gameball.validatitor.condition.ConditionPolicy;

// 유효성 검증 - 중복 체크
public class OverlapNumberPolicy implements ConditionPolicy {

    @Override
    public boolean isSatisfied(String inputString) {
        boolean overlap = true;

        for (int j = inputString.length() - 1; j > 0; j--) {
            int foundIndex = inputString.substring(0, j).indexOf(inputString.charAt(j));

            if (foundIndex > -1) {
                overlap = false;
                break;
            }
        }
        return overlap;
    }
}
