package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Computer {

    public static final int MAX_NUMBER_INDEX = 3;

    public List<Integer> generateRandomNumbers() {
        List<Integer> answer = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(answer);
        return answer.subList(0, MAX_NUMBER_INDEX);
    }
}
