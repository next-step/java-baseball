package baseball.exception;

import baseball.configuration.BaseballConfiguration;

public enum BizExceptionType {

    NUMBER_ONLY("0001","숫자만 입력 가능합니다"),
    INVALID_LENGTH("0002", "입력 자리수가 잘못되었습니다."),
    OUT_OF_BOUNDS_NUMBER("0003", BaseballConfiguration.MIN_NUMBER + "~" + BaseballConfiguration.MAX_NUMBER +"만 입력 가능합니다"),
    DUPLICATE_NUMBER("0004","중복된 값을 입력할 수 없습니다."),
    INVALID_COMMAND("0005","입력 불가능한 명령어 입니다..");

    private final String code;
    private final String message;

    BizExceptionType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
