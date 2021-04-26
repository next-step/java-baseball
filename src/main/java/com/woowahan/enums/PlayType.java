package com.woowahan.enums;

import lombok.Getter;

@Getter
public enum PlayType {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫씽");

    private final String name;

    PlayType(String name) {
        this.name = name;
    }
}
