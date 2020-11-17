package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    public static final int BALL_MIN_SIZE = 0;
    private static final int BALL_MAX_SIZE = 3;

    public List<BaseBallNumber> getNumbers() {
        List<BaseBallNumber> sourceBallNumbers = SourceNumbers.getSourceBallNumbers();
        Collections.shuffle(sourceBallNumbers);
        return Collections.unmodifiableList(new ArrayList<>(sourceBallNumbers.subList(BALL_MIN_SIZE, BALL_MAX_SIZE)));
    }
}
