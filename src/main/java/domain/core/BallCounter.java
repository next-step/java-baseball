package domain.core;

import java.util.List;

public class BallCounter {
    private final List<Integer> answer;

    private BallCounter(List<Integer> answer) {
        this.answer = answer;
    }

    public static BallCounter of(List<Integer> answer){
        return new BallCounter(answer);
    }

    public int getBallCount(List<Integer> input) {
        int ballCount = 0;
        for (int answerIndex = 0; answerIndex < 3; answerIndex++) {
            ballCount = checkIfIndexIsBall(input, answerIndex, ballCount);
        }
        return ballCount;
    }

    private int checkIfIndexIsBall(List<Integer> input, int answerIndex, int ballCount) {
        for (int inputIndex = 0; inputIndex < 3; inputIndex++) {
            ballCount = checkBall(input, answerIndex, ballCount, inputIndex);
        }
        return ballCount;
    }

    private int checkBall(List<Integer> input, int answerIndex, int ballCount, int inputIndex) {
        if (answer.get(answerIndex).equals(input.get(inputIndex)) &&
                answerIndex != inputIndex) {
            ballCount++;
        }
        return ballCount;
    }
}
