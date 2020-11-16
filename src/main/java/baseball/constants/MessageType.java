package baseball.constants;

public enum MessageType {
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    OUTPUT_WIN("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    CONFIRM_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INVALID_RANGE_NUMBER("숫자는 100 이상 999 이하의 3자리 숫자만 입력 가능합니다."),
    INVALID_DUPLI_NUMBER("입력한 숫자의 자릿수 중 중복된 값이 존재합니다."),
    INVALID_CONFIRM_EXIT("입력 가능한 숫자는 1 또는 2만 허용됩니다.");

    private String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
