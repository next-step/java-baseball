package domain;

import domain.exception.BallsDuplicatedNumberException;
import domain.exception.BallsDuplicatedPositionException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    List<Ball> balls = new ArrayList<>();

    public Balls(List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    private void validate(List<Ball> balls) {
        duplicatedBallNumberCheck(balls);
        duplicatedBallPositionCheck(balls);

    }

    private void duplicatedBallPositionCheck(List<Ball> balls) {
        List<Integer> positions = toPositionList(balls);
        if (isDuplicatedPosition(positions)) {
            throw new BallsDuplicatedPositionException();
        }
    }

    private void duplicatedBallNumberCheck(List<Ball> balls) {
        List<Integer> numbers = toNumberList(balls);
        if (isDuplicatedNumber(numbers)) {
            throw new BallsDuplicatedNumberException();
        }
    }

    private List<Integer> toNumberList(List<Ball> ballList) {
        return ballList.stream().map(ball -> ball.number()).collect(Collectors.toList());
    }

    private List<Integer> toPositionList(List<Ball> ballList) {
        return ballList.stream().map(ball -> ball.position()).collect(Collectors.toList());
    }

    private boolean isDuplicatedPosition(List<Integer> positionList) {
        return positionList.size() > positionList.stream().distinct().count();
    }

    private boolean isDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() > numbers.stream().distinct().count();
    }

    public int size() {
        return balls.size();
    }

    public List<Ball> balls() {
        return Collections.unmodifiableList(balls);
    }
}
