package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class BaseballNumberGenerator {
    public List<Integer> generate() {
        Random rand = new Random();
        HashSet<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < 3) {
            int pick = rand.nextInt(9) + 1;
            numberSet.add(pick);
        }

        return shuffle(numberSet);
    }

    public List<Integer> shuffle(HashSet<Integer> numberSet) {
        List<Integer> numberList = new ArrayList<>();
        numberList.addAll(numberSet);
        Collections.shuffle(numberList);

        return numberList;
    }
}
