package com.leeha.baseball.runner;

public enum BaseballGameShutdownOption {

    GAME_START("1"),
    GAME_END("2");

    private final String code;

    BaseballGameShutdownOption(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static boolean exists(String code) {
        boolean exists = false;

        for (BaseballGameShutdownOption option : values()) {
            exists = exists || option.getCode().equalsIgnoreCase(code);
        }

        return exists;
    }
}
