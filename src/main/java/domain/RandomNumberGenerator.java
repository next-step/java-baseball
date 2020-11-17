package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    public static final int BALL_MIN_SIZE = 0;
    private static final int BALL_MAX_SIZE = 3;

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private static List<BaseBallNumber> sourceBallNumbers = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            sourceBallNumbers.add(new BaseBallNumber(i));
        }
    }

    public List<BaseBallNumber> getNumbers() {
        Collections.shuffle(sourceBallNumbers);
        return Collections.unmodifiableList(new ArrayList<>(sourceBallNumbers.subList(BALL_MIN_SIZE, BALL_MAX_SIZE)));
    }
}
