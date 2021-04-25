package baseball.domain;

public enum ProcessType {
    CONTINUE(1),
    STOP(2);

    private final int flagNumber;

    ProcessType(int flagNumber) {
        this.flagNumber = flagNumber;
    }

    public int flagNumber() {
        return this.flagNumber;
    }
}
