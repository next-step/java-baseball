package baseballgame;

public enum ErrorMessageEnum {
    ERROR_INVALID_LENGTH("개의 숫자를 입력하세요."),
    ERROR_INVALID_NUMBER("숫자를 입력해야 합니다."),
    ERROR_DUPLICATE_NUMBER("중복되는 숫자는 넣을 수 없습니다."),
    ;

    String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
