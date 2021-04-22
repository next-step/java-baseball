package domain.enums;

public enum Error {
    INPUT_ERROR("잘못된 숫자를 입력하셨습니다. 3자리의 숫자를 입력해주세요.");

    String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
