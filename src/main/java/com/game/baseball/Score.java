package com.game.baseball;

import java.util.Iterator;
import java.util.Set;

public class Score {

    private Question question;
    private Answer answer;


    public Score(Question question) {
        this.question = question;
    }


    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Result calculate() {
        validateQuestion();
        validateAnswer();
        validateQuestionAndAnswer();

        return new Result(countStrike(question.getData(), answer.getData()), countBall(question.getData(), answer.getData()));
    }


    private void validateQuestion() {
        if (question == null || question.getDataSize() == 0) {
            throw new IllegalStateException("문제(Question)가 입력되지 않았습니다.");
        }
    }

    private void validateAnswer() {
        if (answer == null || answer.getDataSize() == 0) {
            throw new IllegalStateException("정답(Answer)이 입력되지 않았습니다.");
        }

        if (question.getDataSize() > answer.getDataSize() || question.getDataSize() < answer.getDataSize()) {
            throw new IllegalArgumentException("입력된 정답(Answer)이 올바르지 않습니다.");
        }
    }

    private void validateQuestionAndAnswer() {
        if (question.getDataSize() != answer.getDataSize()) {
            throw new IllegalStateException("문제(Question)와 정답(Answer) 길이가 일치하지 않습니다.");
        }
    }

    private int countStrike(Set<Integer> questionSet, Set<Integer> answerSet) {
        int strike = 0;

        Iterator<Integer> questionIterator = questionSet.iterator();
        Iterator<Integer> answerIterator = answerSet.iterator();

        while (questionIterator.hasNext()) {
            strike += getStrikeCount(questionIterator.next(), answerIterator.next());
        }

        return strike;
    }

    private int countBall(Set<Integer> questionSet, Set<Integer> answerSet) {
        int ball = 0;

        Iterator<Integer> questionIterator = questionSet.iterator();
        Iterator<Integer> answerIterator = answerSet.iterator();

        while (questionIterator.hasNext()) {
            ball += getBallCount(questionIterator.next(), answerIterator.next(), questionSet);
        }

        return ball;
    }

    private int getStrikeCount(Integer question, Integer answer) {
        return isStrike(question, answer) ? 1 : 0;
    }

    private int getBallCount(Integer question, Integer answer, Set<Integer> questionSet) {
        if (isStrike(question, answer)) {
            return 0;
        }

        if (questionSet.contains(answer)) {
            return 1;
        }

        return 0;
    }

    private boolean isStrike(Integer question, Integer answer) {
        return question.equals(answer);
    }

}
