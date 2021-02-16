package util;

import static controller.BaseballController.NUMBER_SIZE;

import domain.Number;
import domain.NumberSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberUtil {

    private static final int START_INCLUSIVE_NUM = 1;
    private static final int END_INCLUSIVE_NUM = 9;
    private static final Random random = new Random();
    private static Set<Integer> numberSet = new HashSet<>();
    private static NumberSet systemNumber = new NumberSet();

    private RandomNumberUtil() {
    }

    public static NumberSet getSystemNumber() {
        int numCnt = 0;
        while (numCnt < NUMBER_SIZE) {
            numCnt = pick(numCnt);
        }
        return systemNumber;
    }

    private static int pick(int numCnt) {
        int tmp = getRandomNum(START_INCLUSIVE_NUM, END_INCLUSIVE_NUM);
        if (!numberSet.contains(tmp)) {
            systemNumber.addNumbers(new Number(tmp));
            numCnt++;
        }
        return numCnt;
    }

    private static int getRandomNum(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }
        if (startInclusive < 0) {
            throw new IllegalArgumentException();
        }
        if (startInclusive == endInclusive) {
            return startInclusive;
        }
        return startInclusive + random.nextInt(endInclusive - startInclusive + 1);
    }
}
