package study.baseball.service;

import java.util.Arrays;
import java.util.List;

public class ResultChecker {
    private List<Integer> userNumbers;
    private List<Integer> answerNumbers;

    private int strikeCount;
    private int ballCount;

    public ResultChecker() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void calculateResult() {
        // TODO : 인덴트가 2인 상황
        for (int i=0; i<answerNumbers.size(); i++) {
            if (userNumbers.get(i) == answerNumbers.get(i)) {
                this.strikeCount++;
            } else if (answerNumbers.contains(userNumbers.get(i))) {
                this.ballCount++;
            }
        }
    }

    public void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public void setAnswerNumbers(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void resetGameCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }
}
