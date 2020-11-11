package com.game.baseball;

import lombok.Getter;

@Getter
public enum ResultType {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    ResultType(String message) {
        this.message = message;
    }
}
