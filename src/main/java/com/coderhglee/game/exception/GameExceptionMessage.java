package com.coderhglee.game.exception;

public enum GameExceptionMessage {
    NOT_ALLOW_VALUE_MESSAGE("옳바른 숫자가 아닙니다."),
    EXCEED_ALLOW_LENGTH_MESSAGE("최대 입력 길이를 초과하였습니다."),
    CONTAIN_SAME_NUMBER_MESSAGE("같은 숫자가 포함되어있습니다.");

    public final String message;

    GameExceptionMessage(String message) {
        this.message = message;
    }
}
