package baseball.rule;

import java.util.Random;

public class GameManager {
    private final int ANSWER_LENGTH = 3;
    private final int [] answers = new int[ANSWER_LENGTH];
    private final Random random = new Random();

    public GameManager() {
        generateAnswers();
    }

    public void generateAnswers() {
        for (int i = 0; i < answers.length; i++) {
            int randomNum = random.nextInt(10);
            answers[i] = randomNum;
        }
    }

    public int[] getAnswers() {
        return answers;
    }
}
