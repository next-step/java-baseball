package baseballgame.game;

import java.util.*;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    public static List<Integer> generateRandomNumberList(int lowerBound, int upperBound, int size) {
        checkValidation(lowerBound, upperBound, size);
        final Set<Integer> numberSet = generateRandomNumberSet(lowerBound, upperBound, size);
        return new ArrayList<>(numberSet);
    }

    private static void checkValidation(int lowerBound, int upperBound, int size) {
        checkBoundaryValidation(lowerBound, upperBound);
        checkSizeValidation(size);
    }

    private static void checkBoundaryValidation(int lowerBound, int upperBound) {
        if (upperBound <= lowerBound) {
            throw new IllegalArgumentException(String.format("upperBound must be greater than lowerBound. lowerBound: %d, upperBound: %d", lowerBound, upperBound));
        }
    }

    private static void checkSizeValidation(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(String.format("Size must be greater than zero. size: %d", size));
        }
    }

    private static Set<Integer> generateRandomNumberSet(int lowerBound, int upperBound, int size) {
        final Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < size) {
            final int bound = upperBound - lowerBound + 1;
            final int number = random.nextInt(bound) + lowerBound;
            numberSet.add(number);
        }
        return numberSet;
    }

}
