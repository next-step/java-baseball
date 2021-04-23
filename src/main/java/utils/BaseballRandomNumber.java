package utils;

import domain.BaseballNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballRandomNumber {

    private static final int BASEBALL_ZERO = 0;
    private static final int BASEBALL_ONE = 1;
    private static final int BASEBALL_SIZE = 3;
    private static final int BASEBALL_MAX_NUM = 9;

    public static BaseballNumbers simulationRandomNumber() {
        List<Integer> baseballNumbers = createNumbers();
        Collections.shuffle(baseballNumbers);
        return BaseballNumbers.of((pickNumbers(baseballNumbers)));
    }

    private static List<Integer> createNumbers() {
        List<Integer> baseballNumbers = new ArrayList<>();
        for(int i = BASEBALL_ONE; i <= BASEBALL_MAX_NUM; i++){
            baseballNumbers.add(i);
        }
        return baseballNumbers;
    }

    private static List<Integer> pickNumbers(List<Integer> baseballNumbers) {
        return baseballNumbers.subList(BASEBALL_ZERO, BASEBALL_SIZE);
    }
}
