package com.game.code;

import com.game.common.EnumCode;
import lombok.Getter;

@Getter
public enum OptionCode implements EnumCode {

    RESTART_GAME("1", "게임 새로 시작"),
    EXIT_GAME("2", "게임 종료");

    private final String code;
    private final String message;

    OptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
