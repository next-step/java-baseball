package baseball.model.strategy;

public class LinearStrategy implements AnswerStrategy {
    private static final int ANSWER_SIZE = 3;
    private int answer = 1;

    @Override
    public int pop() {
        return answer++;
    }

    @Override
    public int size() {
        return ANSWER_SIZE;
    }
}