package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballGenerator {


    private static final int BASEBALL_SIZE = 3;
    private static final int BASEBALL_MAX_NUM = 9;

    public static Baseball generateRandomNo() {
        List<Integer> baseballNums = createNums();
        Collections.shuffle(baseballNums);
        return Baseball.of((pickNumbers(baseballNums)));

    }

    private static List<Integer> createNums() {
        List<Integer> baseballNums = new ArrayList<>();
        for(int i = 1; i <= BASEBALL_MAX_NUM; i++){
            baseballNums.add(i);
        }
        return baseballNums;
    }

    private static List<Integer> pickNumbers(List<Integer> baseballNums) {
        return baseballNums.subList(0, BASEBALL_SIZE);
    }

}
