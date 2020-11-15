package game.baseball.number.input;

public enum HelperTexts {

    RESTART_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String helperMessage;

    HelperTexts(String helperMessage) {
        this.helperMessage = helperMessage;
    }

    public String getHelperMessage() {
        return helperMessage;
    }
}