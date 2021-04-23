package baseball.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private final List<Ball> balls;

    public Balls(Ball ...balls) {
        this(Arrays.asList(balls));
    }

    public Balls(List<Ball> balls) {
        Set<Ball> ballSet = new HashSet<>(balls);
        if(ballSet.size() != balls.size()) {
            throw new IllegalArgumentException("같은 공의 숫자를 가질 수 없습니다.");
        }

        this.balls = balls;
    }
}
