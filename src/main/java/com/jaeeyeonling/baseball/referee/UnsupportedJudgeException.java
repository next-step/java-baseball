package com.jaeeyeonling.baseball.referee;

import com.jaeeyeonling.baseball.BaseballException;

public final class UnsupportedJudgeException extends BaseballException {

    private static final String MESSAGE = "지원하지 않는 판정입니다.";

    public UnsupportedJudgeException() {
        super(MESSAGE);
    }
}
