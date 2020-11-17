package game.baseball.number.utils;

public enum HelperTexts {

    RESTART_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INPUT_NUMBER("숫자를 입력해주세요 : ");

    private final String helperMessage;

    HelperTexts(String helperMessage) {
        this.helperMessage = helperMessage;
    }

    @Override
    public String toString() {
        return helperMessage;
    }
}
