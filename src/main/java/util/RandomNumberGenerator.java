package util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();

    private RandomNumberGenerator() {
    }

    public static String nextString(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }
        if (startInclusive < 0) {
            throw new IllegalArgumentException();
        }
        if (startInclusive == endInclusive) {
            return Integer.toString(startInclusive);
        }
        return Integer.toString(startInclusive + RANDOM.nextInt(endInclusive - startInclusive) + 1);
    }
}
