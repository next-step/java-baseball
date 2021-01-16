public enum OutputMessage {

    GAME_FINISHED("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    PLEASE_ENTER_NUMBER("숫자를 입력해 주세요 : "),
    PLEASE_ENTER_AGAIN(" 다시 입력해 주세요 : "),
    PLAY_A_NEW_GAME_OR_NOT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. "),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return this.message;
    }
}
