package com.leeha.baseball.runner;

public enum GameOperator {

    START("1", "게임 시작"),
    END("2", "게임 종료");

    private final String code;
    private final String description;

    GameOperator(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public static GameOperator toGameOperator(String code) {
        for (GameOperator operator : values()) {
            if (operator.getCode().equalsIgnoreCase(code)) {
                return operator;
            }
        }

        return null;
    }
}
