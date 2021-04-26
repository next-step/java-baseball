package baseball;

public enum Message {

    START(" 중복되지 않는 3자리의 1~9 숫자를 입력해주세요 : "),
    INVALID("올바른 입력값이 아닙니다. 다시 입력해주세요."),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("나싱"),
    WIN("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
