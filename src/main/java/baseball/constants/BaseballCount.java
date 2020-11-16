package baseball.constants;

public enum BaseballCount {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String name;

    BaseballCount(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
