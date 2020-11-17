package exception;

public enum ExceptionMessage {

    NONE_VALID_INPUT_VALUE ("입력할 수 있는 범위가 아닙니다."),
    NONE_VALID_INPUT_RANGE ("각 자리 숫자는 1~9까지로 이루어져야 합니다."),
    WRONG_INPUT_NUMBER_LENGTH("세자리 정수를 입력해 주세요"),
    DUPLICATE_INPUT_NUMBER("입력한 각 자리 숫자는 중복 될 수 없습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
