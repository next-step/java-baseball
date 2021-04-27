package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 볼을 생성합니다.
 */
public class BallGenerator {
    private static int MAX_BALL_COUNT = 3;
    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 9;

    private BallGenerator() {
    }

    /**
     * 공의 숫자를 가져옵니다.
     */
    public static BallNumbers getBallNumbers() {
        List<BallNumber> ballNumbers = shuffle(generateNumbers()).subList(0, MAX_BALL_COUNT);
        return new BallNumbers(ballNumbers);
    }

    public static List<BallNumber> generateNumbers() {
        final List<BallNumber> ballNumbers = new ArrayList<>();
        for (int i = MINIMUM_BALL_NUMBER; i <= MAXIMUM_BALL_NUMBER; i++) {
            ballNumbers.add(new BallNumber(i));
        }
        return ballNumbers;
    }

    private static List<BallNumber> shuffle(List<BallNumber> ballNumbers) {
        Collections.shuffle(ballNumbers);
        return ballNumbers;
    }
}
