package jito.baseball.domain;

public enum BaseBallStatus {
    STRIKE("스트라이크 "),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    BaseBallStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}