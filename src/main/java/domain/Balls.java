package domain;

import domain.exception.BallsDuplicatedNumberException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Balls {

    List<Ball> balls = new ArrayList<>();

    public Balls(List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    private void validate(List<Ball> balls) {
        duplicatedBallNumberCheck(balls);
        duplicatedBallPositionCheck();

    }

    private void duplicatedBallPositionCheck() {
    }

    private void duplicatedBallNumberCheck(List<Ball> balls) {
        if (isDuplicatedNumber(balls)) {
            throw new BallsDuplicatedNumberException();
        }
    }

    private boolean isDuplicatedNumber(List<Ball> balls) {
        return balls.size() > balls.stream().distinct().count();
    }

    public int size() {
        return balls.size();
    }

    public List<Ball> balls() {
        return Collections.unmodifiableList(balls);
    }
}
