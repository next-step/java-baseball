package baseball.game.domain.generator;

import baseball.game.domain.Balls;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BallNumberProvider {

    private BallNumberProvider() {
    }

    public static List<Integer> getNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(numbers);

        return numbers.subList(0, Balls.LIMIT_BALL_SIZE);
    }
}
