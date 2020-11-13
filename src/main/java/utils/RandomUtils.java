package utils;

public class RandomUtils {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static int random() {
        return (int) (MIN_NUMBER + Math.random() * MAX_NUMBER);
    }
}
