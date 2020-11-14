package utils;

public final class RandomUtils {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private RandomUtils() {
    }

    public static int random() {
        return (int) (MIN_NUMBER + Math.random() * MAX_NUMBER);
    }
}
