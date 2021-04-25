package com.github.momentjin.service;

import com.github.momentjin.model.BaseballNumberBundle;
import com.github.momentjin.model.BaseballNumberBundleMatcher;
import com.github.momentjin.model.BaseballNumberDomainException;
import com.github.momentjin.model.BaseballNumberMatchResult;

public class BaseballApplicationService {

    private final BaseballNumberBundleMatcher matcher;

    public BaseballApplicationService(BaseballNumberBundleMatcher matcher) {
        this.matcher = matcher;
    }

    public BaseballNumberMatchResult checkAnswer(BaseballNumberBundle answer, BaseballNumberBundle target) {

        try {
            return matcher.match(answer, target);
        } catch(BaseballNumberDomainException e) {
            return new BaseballNumberMatchResult(e);
        }
    }
}
