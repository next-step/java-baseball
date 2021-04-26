package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Answer {
    public static final int ANSWER_SIZE = 3;
    public static final int ANSWER_LOWER_BOUND_NUMBER = 1;
    public static final int ANSWER_UPPER_BOUND_NUMBER = 9;

    private List<Integer> answer;

    public Answer() {
        generateAnswer();
    }

    public void generateAnswer() {
        answer = new ArrayList<>();
        for (int i = 0;i<ANSWER_SIZE;i++) {
            int generatedRandomValue = generateRandomValue(ANSWER_LOWER_BOUND_NUMBER, ANSWER_UPPER_BOUND_NUMBER);
            answer.add(generatedRandomValue);
        }
    }

    private int generateRandomValue(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public List<Integer> getAnswer() {
        return answer;
    }

}
