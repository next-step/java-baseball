package baseball;

import util.NumberExtractor;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private static final int BALL_COUNT = 3;
    private static final int MAX_NUMBER = 9;
    private List<Integer> ballList;

    public Balls() {
        setRandomBall();
    }

    public Balls(List<Integer> newBalls) {
        this.ballList = newBalls;
    }

    //점수 매기기
    public Score compare(Balls userBalls) {
        List<Integer> userBallList = userBalls.ballList;
        Score score = new Score();
        // strike 확인
        checkStrike(userBallList, score);
        // ball 확인
        checkBall(userBallList, score);

        return score;
    }

    private void setRandomBall() {
        ballList = new ArrayList<>();
        while (ballList.size() < BALL_COUNT) {
            this.add(NumberExtractor.random(MAX_NUMBER));
        }
    }

    private void add(int number) {
        if (ballList.contains(number)) {
            return;
        }

        ballList.add(number);
    }

    private void checkStrike(List<Integer> userBallList, Score score) {
        for (int i = 0; i < BALL_COUNT; i++) {
            calculateStrike(userBallList, score, i);
        }
    }

    private void calculateStrike( List<Integer> userBallList, Score score, int index) {
        List<Integer> computerBallList = this.ballList;
        if (computerBallList.get(index).equals(userBallList.get(index))) {
            score.addStrike();
        }
    }

    private void checkBall(List<Integer> userBallList, Score score) {
        for (int userBallIndex = 0; userBallIndex < userBallList.size(); userBallIndex++) {
            Integer userBall = userBallList.get(userBallIndex);
            calculateBall(score, userBallIndex, userBall);
        }
    }

    private void calculateBall(Score score, int userBallIndex, Integer userBall) {
        List<Integer> computerBallList = this.ballList;
        if (computerBallList.contains(userBall) && userBallIndex != computerBallList.indexOf(userBall)) {
            score.addBall();
        }
    }
}
