package com.github.momentjin.service;

import com.github.momentjin.model.BaseballNumber;
import com.github.momentjin.model.BaseballNumberBundle;
import com.github.momentjin.model.BaseballNumberMatchResult;

public class BaseballNumberBundleMatcher {

    public BaseballNumberMatchResult match(BaseballNumberBundle origin, BaseballNumberBundle target) {

        int strikeCount = calculateStrikeCount(origin, target);
        int ballCount = calculateBallCount(origin, target);

        return new BaseballNumberMatchResult(
                origin.size(),
                strikeCount,
                ballCount
        );
    }

    private int calculateStrikeCount(BaseballNumberBundle origin, BaseballNumberBundle target) {

        int strikeCount = 0;

        for (int index = 0; index < origin.size(); index++) {
            BaseballNumber targetNumber = target.getBaseballNumber(index);
            strikeCount += origin.isStrike(index, targetNumber) ? 1 : 0;
        }

        return strikeCount;
    }

    private int calculateBallCount(BaseballNumberBundle origin, BaseballNumberBundle target) {

        int ballCount = 0;

        for (int index = 0; index < origin.size(); index++) {
            BaseballNumber targetNumber = target.getBaseballNumber(index);
            ballCount += origin.isBall(index, targetNumber) ? 1 : 0;
        }

        return ballCount;
    }
}
