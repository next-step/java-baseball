package domain.enums;

public enum Error {
    INPUT_ERROR("잘못된 숫자를 입력하셨습니다. 각 자리 숫자가 중복되지 않는 3자리 숫자를 입력해주세요.");

    String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
