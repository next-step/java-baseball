package baseball.rule;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameManager {
    private final int ANSWER_LENGTH = 3;
    private Integer[] answers;
    private final Random random = new Random();

    public GameManager() {
        generateAnswers();
    }

    public void generateAnswers() {
        Set<Integer> set = new HashSet<>();

        while(set.size() < ANSWER_LENGTH) {
            int randomNum = random.nextInt(10);
            set.add(randomNum);
        }

        answers = set.toArray(new Integer[0]);
    }

    public Integer[] getAnswers() {
        return answers;
    }

}
