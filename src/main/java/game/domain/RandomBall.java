package game.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomBall {

    private static final int START_NUM = 1;
    private static final int END_NUM = 9;
    private static final int RANDOM_COUNT = 3;
    private Baseball randomBall;

    public RandomBall() {
        randomBall = new Baseball();
        List<BallNumber> balls = makeRandomBall();
        IntStream.rangeClosed(START_NUM, RANDOM_COUNT)
            .forEach(i -> randomBall.addBall(balls.get(i)));
    }

    public Baseball getRandomBall() {
        return randomBall;
    }

    private List<BallNumber> makeRandomBall() {
        List<BallNumber> balls = IntStream
            .rangeClosed(START_NUM, END_NUM)
            .boxed()
            .map(BallNumber::new)
            .collect(Collectors.toList());
        Collections.shuffle(balls);
        return balls;
    }
}
