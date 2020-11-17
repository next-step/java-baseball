package edu.example.numberbaseball.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 야구게임 1회를 구성하는 정보를 가진 `Inning`
 */
public class Inning {
    private static final int NUMBER_OF_BALLS = 3;

    private final List<Ball> ballList;

    public Inning(List<Ball> ballsList) {
        if (ballsList.size() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException("입력된 Ball의 갯수가 " + NUMBER_OF_BALLS + "개가 되지 않습니다.");
        }
        if (isDuplicated(ballsList)) {
            throw new IllegalArgumentException("입력된 Ball 숫자 중에서 중복되는 수가 존재합니다.");
        }
        this.ballList = ballsList;
    }

    public Inning() {
        this.ballList = generateBallList();
    }

    public List<Integer> getBallNumberList() {
        return getBallNumberList(ballList);
    }

    private List<Ball> generateBallList() {
        return new BallGenerator().generateRandomBallList(NUMBER_OF_BALLS);
    }

    private List<Integer> getBallNumberList(List<Ball> ballsList) {
        List<Integer> numberList = new ArrayList<>(NUMBER_OF_BALLS);
        for (Ball ball : ballsList) {
            numberList.add(ball.getNumber());
        }
        return numberList;
    }

    private boolean isDuplicated(List<Ball> ballsList) {
        Set<Integer> ballNumberSet = new HashSet<>(NUMBER_OF_BALLS);
        ballNumberSet.addAll(getBallNumberList(ballsList));
        return ballNumberSet.size() != NUMBER_OF_BALLS;
    }

    public static int getNumberOfBalls() {
        return NUMBER_OF_BALLS;
    }
}
