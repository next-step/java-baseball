package com.game.code;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // [01xx] BaseballGame
    INVALID_BASEBALL_NUMBER("0101", "유효하지 않은 숫자입니다.");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
