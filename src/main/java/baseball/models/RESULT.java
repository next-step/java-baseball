package baseball.models;

public enum RESULT {

    INITIALIZE(0), RESTART(1), EXIT(2);

    private final int value;


    RESULT(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public static RESULT valueOf(int value) {
        switch (value) {
            case 1: return RESTART;
            case 2: return EXIT;
            default: throw new AssertionError("Unknown value: " + value);
        }
    }

}

