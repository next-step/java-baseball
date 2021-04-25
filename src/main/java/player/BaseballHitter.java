package player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballHitter {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int SIZE = 3;

    private List<Integer> numbers = new ArrayList<>();

    public BaseballHitter() {
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            numbers.add(i);
        }
        hittingBall();
    }

    public void hittingBall() {
        Collections.shuffle(numbers);
        this.numbers = numbers.subList(0, SIZE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
