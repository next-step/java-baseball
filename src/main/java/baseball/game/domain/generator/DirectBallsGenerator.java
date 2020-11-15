package baseball.game.domain.generator;

import baseball.game.domain.Ball;
import baseball.game.domain.Balls;
import java.util.ArrayList;
import java.util.List;

public class DirectBallsGenerator {

    private DirectBallsGenerator() {
    }

    public static Balls generate(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();

        for (Integer number : numbers) {
            balls.add(Ball.of(number));
        }

        return Balls.create(balls);
    }
    
}
