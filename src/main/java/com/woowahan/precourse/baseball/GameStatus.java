package com.woowahan.precourse.baseball;

public enum GameStatus {
    RESTART("1"),
    END("2");

    private String status;

    GameStatus(String status) {
        this.status = status;
    }
}
