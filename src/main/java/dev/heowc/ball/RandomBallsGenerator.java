package dev.heowc.ball;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomBallsGenerator implements BallsGenerator {

    private final List<Integer> rawBallList;

    public RandomBallsGenerator() {
        final List<Integer> list = new ArrayList<>();
        for (int i = Ball.MIN_VALUE; i <= Ball.MAX_VALUE; i++) {
            list.add(i);
        }
        rawBallList = list;
    }

    @Override
    public Balls generate() {
        final List<Integer> clonedRawBallList = new ArrayList<>(rawBallList);

        final List<Ball> ballList = new ArrayList<>(Balls.SIZE);
        for (int i = 0; i < Balls.SIZE; i++) {
            final int index = randomIndex(clonedRawBallList);
            final Integer rawBall = clonedRawBallList.remove(index);
            ballList.add(Ball.valueOf(rawBall));
        }
        return Balls.of(ballList);
    }

    private int randomIndex(List<Integer> clonedRawBallList) {
        return ThreadLocalRandom.current().nextInt(clonedRawBallList.size() - 1);
    }
}
