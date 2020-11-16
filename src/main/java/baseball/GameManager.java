package baseball;

import java.util.Random;

public class GameManager {
    private final int [] answers = new int[3];
    Random random = new Random();

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
