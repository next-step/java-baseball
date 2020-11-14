package me.totoku103.baseball;

public enum MessageConstants {
    USER_INPUT("숫자를 입력해주세요"),
    INVALID_INPUT("다시 입력해주세요"),
    STRIKE("스트라이크"),
    BALL("볼"),
    NO_MATCH("낫씽"),
    GAME_END("숫자를 모두 맞히셨습니다! 게임 종료"),
    GMAE_MODE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

    private String message;

    MessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
