package com.leeha.baseball.controller.inspector;

import static com.leeha.baseball.exception.BaseballGameExceptionCode.INVALID_ANSWER_EXCEPTION;

import com.leeha.baseball.exception.InvalidAnswerException;
import java.util.List;
import java.util.ListIterator;

import com.leeha.baseball.controller.GameScore;

public class BaseballGameInspector {

    public boolean inspect(List<Integer> balls, List<String> answer) {
        validateParameter(balls, answer);

        ListIterator<Integer> iterator = balls.listIterator();
        GameScore score = new GameScore();

        while (iterator.hasNext()) {
            calculateScore(score, balls, iterator.next(), answer.get(iterator.nextIndex() - 1));
        }

        return score.isPerfectScore(balls.size());
    }

    private void validateParameter(List<Integer> balls, List<String> answer) {
        if (balls.size() != answer.size()) {
            throw new InvalidAnswerException(INVALID_ANSWER_EXCEPTION);
        }
    }

    private void calculateScore(GameScore score, List<Integer> balls, Integer correctAnswer, String answer) {
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