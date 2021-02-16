package utils;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static int generateIntegers() {
        return random.nextInt(9) + 1;
    }
}
