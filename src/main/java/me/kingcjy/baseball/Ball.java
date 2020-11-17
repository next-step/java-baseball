package me.kingcjy.baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KingCjy
 */
public class Ball {

    private List<BallNumber> numbers = new ArrayList<>();

    public Ball(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            this.numbers.add(new BallNumber(numbers[i], i));
        }
    }

    public List<BallNumber> getNumbers() {
        return numbers;
    }

    public BallCount judgeBallCount(Ball other) {
        return null;
    }
}
