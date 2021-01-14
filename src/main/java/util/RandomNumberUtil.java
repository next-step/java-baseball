package util;

import domain.BaseballGame;

import java.util.Random;

import static domain.BaseballGame.INPUT_NUMBER_SIZE;

public class RandomNumberUtil {
    private static final Random RANDOM = new Random();
    static final int START_INCLUSIVE_NUM = 1;
    static final int END_INCLUSIVE_NUM = 9;
    static boolean[] checkDistinct = new boolean[10];

    public static int[] getDistinctNumber() {
        int[] systemNum = new int[INPUT_NUMBER_SIZE];
        int numCnt = 0;
        while (numCnt < INPUT_NUMBER_SIZE) {
            int tmp = getRandomNum(START_INCLUSIVE_NUM, END_INCLUSIVE_NUM);
            if (isDistinct(tmp)) {
                systemNum[numCnt++] = tmp;
            }
        }
        return systemNum;
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
        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }

    private static boolean isDistinct(int checkNum) {
        if(!checkDistinct[checkNum]) {
            checkDistinct[checkNum] = true;
            return true;
        } else {
            return false;
        }
    }
}
