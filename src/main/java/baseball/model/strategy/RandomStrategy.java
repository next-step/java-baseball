package baseball.model.strategy;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class RandomStrategy implements AnswerStrategy {
    private static final int ANSWER_SIZE = 3;
    private static final int START_NUMBER = 1;
    private static final int ANSWER_BOUNDARY = 9;

    private static final String EMPTY_ERROR_MESSAGE = String
            .format("AnswerNumber는 %d 개를 초과하여 호출할 수 없습니다.", ANSWER_SIZE);

    private final Random random = new Random();
    private final Stack<Integer> answers = new Stack<>();

    public RandomStrategy() {
        final Set<Integer> baseballNumberSet = new HashSet<>();
        while (baseballNumberSet.size() < ANSWER_SIZE) {
            final int randomNumber = START_NUMBER + random.nextInt(ANSWER_BOUNDARY);
            baseballNumberSet.add(randomNumber);
        }
        answers.addAll(baseballNumberSet);
    }

    @Override
    public int pop() {
        if (answers.size() == 0) {
            throw new IllegalStateException(EMPTY_ERROR_MESSAGE);
        }
        return answers.pop();
    }

    @Override
    public int size() {
        return ANSWER_SIZE;
    }
}