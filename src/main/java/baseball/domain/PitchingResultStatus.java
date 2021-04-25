package baseball.domain;

public enum PitchingResultStatus {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String koName;

    PitchingResultStatus(String koName) {
        this.koName = koName;
    }
}
