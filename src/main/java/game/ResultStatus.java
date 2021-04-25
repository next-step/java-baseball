package game;

public enum ResultStatus {
    STRIKE(0, "스트라이크"), BALL(1, "볼"), NOTING(2, "낫싱");

    private final int index;
    private final String name;

    ResultStatus(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
