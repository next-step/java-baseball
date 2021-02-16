package game.domain;

public enum Unit {
    NOTHING("낫싱"),
    STRIKE("스트라이크 "),
    BALL("볼 ");

    private String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
