package baseballgame;

public enum GameMessageEnum {
    STRIKE(" 스트라이크 "),
    BALL("볼"),
    NOTHING("낫싱"),
    INPUT_NUMBER("숫자를 입력해 주세요 : "),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임종료"),
    NEW_GAME("게임을 새로 시작혀려면 1, 종료하려면 2를 입력하세요")
    ;

    String message;

    GameMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
