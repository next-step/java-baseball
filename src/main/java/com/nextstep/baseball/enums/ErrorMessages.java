package com.nextstep.baseball.enums;

import com.nextstep.baseball.handler.GameLogicHandler;

public enum ErrorMessages {
    INPUT_LENGTH_OVER(1, "입력값의 길이가 " + GameLogicHandler.INPUT_LENGTH + "보다 깁니다"),
    INPUT_LENGTH_UNDER(2, "입력값의 길이가 " + GameLogicHandler.INPUT_LENGTH + "보다 짧습니다"),
    INPUT_TYPE(3, "입력값이 숫자가 아닙니다");

    private int code;
    private String message;

    ErrorMessages(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static ErrorMessages findByCode(int code) {
        ErrorMessages result = null;
        for (ErrorMessages errorMessage : ErrorMessages.values()) {
            result = compareByCodeAndSetResult(result, errorMessage, code);
        }
        return result;
    }

    private static ErrorMessages compareByCodeAndSetResult(ErrorMessages result, ErrorMessages target, int code) {
        if (result != null) {
            return result;
        }

        if (target.getCode() == code) {
            result = target;
        }
        return result;
    }
}
