package domain;

public enum BaseBallCountText {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String value;

    BaseBallCountText(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
