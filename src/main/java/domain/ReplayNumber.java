package domain;

public enum ReplayNumber {
    REPLAY(1, true),
    END(2, false);

    private final int number;
    private final boolean result;

    ReplayNumber(int number, boolean result) {
        this.number = number;
        this.result = result;
    }

    public static boolean valueOf(int number) {
        if (number == REPLAY.number) {
            return REPLAY.result;
        }

        if (number == END.number) {
            return END.result;
        }

        throw new IllegalArgumentException("잘못된 값입니다.");
    }
}
