package model.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BallFactory {
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    @Getter
    private static final List<Ball> BALLS = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            BALLS.add(Ball.of(i));
        }
    }

    private BallFactory() {
    }

    public static List<Ball> createBalls() {
        Collections.shuffle(BALLS);

        return BALLS.subList(0, 3);
    }
}
