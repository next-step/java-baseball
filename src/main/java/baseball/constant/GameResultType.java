package baseball.constant;

public enum GameResultType {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String value;

    GameResultType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getCode() {
        return name();
    }
}
