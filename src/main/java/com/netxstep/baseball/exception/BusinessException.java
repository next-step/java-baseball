package com.netxstep.baseball.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private String code;
    private String message;

    public BusinessException(BusinessError error) {
        this.code = error.name();
        this.message = error.getMessage();
    }
}
