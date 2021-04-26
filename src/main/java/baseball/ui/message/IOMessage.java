package baseball.ui.message;

public enum IOMessage {

    REQUIRE_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    STRIKE(" 스트라이크 "),
    BALL(" 볼 "),
    NOTHING("낫싱"),
    CORRECT_ANSWER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_REPLAY_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    END("게임이 종료 되었습니다.");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
