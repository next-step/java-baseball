package basball.application;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberFactory {

    private final List<Integer> baseNumber = Arrays.asList(1,2,3,4,5,6,7,8,9);

    public List<Integer> createRandomNumber() {
        Collections.shuffle(baseNumber);
        return baseNumber.subList(0,3);
    }
}
