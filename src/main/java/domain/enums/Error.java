package domain.enums;

public enum Error {
    WRONG_INPUT("잘못된 숫자를 입력하셨습니다."),
    CONTAIN_ZERO_OR_WORD("각 자리의 숫자는 1~9 사이의 숫자만 입력할 수 있습니다."),
    DUPLICATE_NUMBER("각 자리 숫자가 중복되지 않게 입력해주세요."),
    DIGIT_LENGTH("3자리 숫자를 입력해주세요.");

    String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
