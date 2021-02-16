package baseball.model;

import baseball.model.strategy.AnswerStrategy;

import java.util.*;
import java.util.stream.IntStream;

public class AnswerNumbers {
    private static final String BOUNDARY_LIMIT_ERROR_MESSAGE = "AnswerNumber는 %d의 포지션을 초과하여 호출할 수 없습니다.";

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

    public int getAnswerNumber(int position) {
        if (position >= answerNumbers.size()) {
            throw new IllegalArgumentException(String.format(BOUNDARY_LIMIT_ERROR_MESSAGE, answerNumbers.size()));
        }

        return answerNumbers.get(position);
    }
}