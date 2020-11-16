package com.netxstep.baseball.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BusinessError {

    INVALID_VALUE("서로 다른 수를 입력 해 주세요."),
    INVALID_VALUE_LENGTH("3자리 수를 입력 해 주세요");

    private String message;
}
