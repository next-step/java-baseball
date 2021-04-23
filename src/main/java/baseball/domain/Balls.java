package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private final Set<Ball> balls;

    public Balls(Ball ...balls) {
        this(Arrays.asList(balls));
    }

    public Balls(List<Ball> balls) {
        this.balls = new HashSet<>(balls);
    }
}
