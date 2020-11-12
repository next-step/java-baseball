package baseball.domain;

public enum MatchResult {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String message;

    MatchResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
