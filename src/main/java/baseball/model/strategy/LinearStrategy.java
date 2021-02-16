package baseball.model.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinearStrategy implements AnswerStrategy {
    private static final String EMPTY_ERROR_MESSAGE = "AnswerNumber는 %d 개를 초과하여 호출할 수 없습니다.";
    private static final int ANSWER_SIZE = 3;
    private static final int START_NUMBER = 1;

    private final Stack<Integer> answers = new Stack<>();

    public LinearStrategy() {
        addAnswers();
    }

    @Override
    public int pop() {
        if (answers.size() == 0) {
            throw new IllegalStateException(String.format(EMPTY_ERROR_MESSAGE, ANSWER_SIZE));
        }
        return answers.pop();
    }

    @Override
    public int size() {
        return ANSWER_SIZE;
    }

    private void addAnswers() {
        List<Integer> tempAnswers = IntStream
                .range(START_NUMBER, START_NUMBER + ANSWER_SIZE)
                .boxed()
                .collect(Collectors.toList());

        //1,2,3...으로 스택을 꺼내기 위해
        Collections.reverse(tempAnswers);

        answers.addAll(tempAnswers);
    }
}