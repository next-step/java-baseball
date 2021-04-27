package com.bistros.game.domain.game;

import java.util.Arrays;
import java.util.Optional;

public enum GameOperatorType {
    RESTART("1", "새로 시작"),

    END("2", "종료");

    private String code;
    private String description;

    GameOperatorType(String code, String description) {
        this.code = code;
        this.description = description;
    }


    public String getCode() {
        return code;
    }

    public static Optional<GameOperatorType> fromString(String str) {
        return Arrays.stream(values()).filter(c -> c.code.equals(str))
            .findFirst();
    }
}
