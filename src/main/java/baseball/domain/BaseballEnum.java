package baseball.domain;

public enum BaseballEnum {
    STRIKE("스트라이크"),
    BALL("볼"),
    OUT("아웃");

    private final String message;

    BaseballEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
