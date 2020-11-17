package com.leeha.baseball.controller.inspector;

import static com.leeha.baseball.exception.BaseballGameExceptionCode.*;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import com.leeha.baseball.controller.BaseballGameScore;
import com.leeha.baseball.exception.InvalidAnswerException;

public class BaseballGameInspector {

    public boolean inspect(List<Integer> balls, List<String> answer) {
        validateParameter(balls, answer);

        BaseballGameScore score = new BaseballGameScore();
        compareAnswer(balls, answer, score);

        score.displayScore();
        return score.isPerfectScore(balls.size());
    }

    private void validateParameter(List<Integer> balls, List<String> answer) {
        if (Objects.isNull(answer)) {
            throw new InvalidAnswerException(INVALID_ANSWER_EXCEPTION);
        }

        if (balls.size() != answer.size()) {
            throw new InvalidAnswerException(INVALID_ANSWER_EXCEPTION);
        }
    }

    private void compareAnswer(List<Integer> balls, List<String> answer, BaseballGameScore score) {
        ListIterator<Integer> iterator = balls.listIterator();

        while (iterator.hasNext()) {
            calculateScore(score, balls, iterator.next(), answer.get(iterator.nextIndex() - 1));
        }
    }

    private void calculateScore(BaseballGameScore score, List<Integer> balls, Integer correctAnswer, String answer) {
        if (isStrike(correctAnswer, Integer.parseInt(answer))) {
            score.addStrike();
            return;
        }

        if (isBall(balls, Integer.parseInt(answer))) {
            score.addBall();
        }
    }

    private boolean isStrike(Integer correctAnswer, Integer answer) {
        return correctAnswer.equals(answer);
    }

    private boolean isBall(List<Integer> balls, Integer answerBall) {
        return balls.contains(answerBall);
    }
}
