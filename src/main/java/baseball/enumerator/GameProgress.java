package baseball.enumerator;

public enum GameProgress {
    RESTART(1), EXIT(2);

    private final int value;

    GameProgress(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
