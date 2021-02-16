package baseball.model;

import baseball.model.strategy.AnswerStrategy;

import java.util.*;
import java.util.stream.IntStream;

public class AnswerNumbers {
    private final List<Integer> answerNumbers = new ArrayList<>();
    private final AnswerStrategy answerStrategy;

    public AnswerNumbers(AnswerStrategy answerStrategy) {
        this.answerStrategy = answerStrategy;
        makeRandomAnswer();
    }

    private void makeRandomAnswer() {
        IntStream
                .range(0, answerStrategy.size())
                .map(index -> answerStrategy.pop())
                .forEach(answerNumbers::add);
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }
}