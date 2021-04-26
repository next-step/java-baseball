package precourse.constant;

public enum BaseballGameMessage {

    GUESS_ANSWER("숫자를 입력해주세요 :"),
    INVALID_ANSWER("유효하지 않은 숫자입니다."),
    CORRECT_ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    CHOOSE_NEW_GAME_OR_QUIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 :");

    private String content;

    BaseballGameMessage(String content) {
        this.content = content;
    }

    public String content() {
        return content;
    }
}
