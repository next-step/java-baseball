package baseball;

public enum Pitching {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String korean;

    Pitching(String korean) {
        this.korean = korean;
    }


    @Override
    public String toString() {
        return korean;
    }
}
