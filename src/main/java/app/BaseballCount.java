package app;

/**
 * 숫자 야구 카운트 enum
 */
public enum BaseballCount {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String value;

    BaseballCount(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
