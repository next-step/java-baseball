package domain;

import java.util.*;

public class RandomNumber {

    public static List<Integer> createRandomNumber() {
        List<Integer> numList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            numList.add(i);
        }

        Collections.shuffle(numList);

        return numList.subList(0, 3);
    }
}
