package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballHitter {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int SIZE = 3;

    private static final List<Integer> initNumbers = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();

    public BaseballHitter() {
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            initNumbers.add(i);
        }
        hittingBall();
    }

    private void hittingBall() {
        Collections.shuffle(initNumbers);
         numbers = initNumbers.subList(0, SIZE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
