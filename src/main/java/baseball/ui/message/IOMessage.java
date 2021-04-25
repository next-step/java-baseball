package baseball.ui.message;

public enum IOMessage {

    REQUIRE_NUMBER_MESSAGE("숫자를 입력해주세요 : ");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
