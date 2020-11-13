package baseball.domain;

public enum NumberResult {
    OUT("아웃"),
    STRIKE("스트라이크"),
    BALL("볼");

    private final String text;

    NumberResult(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
