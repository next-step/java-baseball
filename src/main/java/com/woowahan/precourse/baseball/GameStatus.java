package com.woowahan.precourse.baseball;

public enum GameStatus {
    RESTART("1"),
    END("2");

    private String value;

    GameStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
