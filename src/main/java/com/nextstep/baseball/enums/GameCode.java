package com.nextstep.baseball.enums;

public enum GameCode {
    EXIT(0),
    CONTINUE(1),
    NEW_GAME(2),
    START(3);

    private int code;

    GameCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
