package baseball.domain;

import java.util.*;

public class RandomNumber {

    private final List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final int START_SUBSTRING_NUMBER = 0;
    private static final int END_SUBSTRING_NUMBER = 3;



    public List<Integer> createRandomNumber() {
        shuffle();
        return this.numberList.subList(START_SUBSTRING_NUMBER, END_SUBSTRING_NUMBER);
    }



    private void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(numberList, new Random(seed));
    }

}
