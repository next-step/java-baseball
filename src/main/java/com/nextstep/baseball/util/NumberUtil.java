package com.nextstep.baseball.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberUtil {
    public static List<Integer> makeRandomNumberList(int size) {
        List<Integer> randomNumList = new ArrayList<>();
        while (randomNumList.size() < size) {
            addRandomNumberNotDuplicated(randomNumList);
        }
        return randomNumList;
    }

    private static void addRandomNumberNotDuplicated(List<Integer> randomNumList) {
        Random random = new Random();
        int num = random.nextInt(9) + 1;

        if (!randomNumList.contains(num)) {
            randomNumList.add(num);
        }
    }

    public static int isEqual(int source, int target) {
        return source == target ? 1 : 0;
    }

    public static int makeDigitListToNum(List<Integer> digitList) {
        int result = 0;
        int mul = 1;

        for (int i = digitList.size() - 1; i >= 0; i--) {
            result += digitList.get(i) * mul;
            mul *= 10;
        }

        return result;
    }

}
