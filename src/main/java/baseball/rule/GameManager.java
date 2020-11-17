package baseball.rule;

import java.util.*;

public class GameManager {
    private final int ANSWER_LENGTH = 3;
    private Integer[] answers;
    private final Random random = new Random();

    public GameManager() {
        generateAnswers();
    }

    public GameManager(Integer[] answers) {
        this.answers = answers;
    }

    public void generateAnswers() {
        Set<Integer> generateSet = new HashSet<>();

        while(generateSet.size() < ANSWER_LENGTH) {
            int randomNum = random.nextInt(10);
            generateSet.add(randomNum);
        }

        answers = generateSet.toArray(new Integer[0]);
    }

    public Integer[] getAnswers() {
        return answers;
    }

    public GameResult judge(Integer[] inputNums) {
        int strike = getStrike(inputNums);
        int ball = getBall(inputNums, strike);
        return new GameResult(strike, ball);
    }

    private int getBall(Integer[] inputNums, int strike) {
        Set<Integer> intersectionSet = new HashSet<>(Arrays.asList(inputNums));
        Set<Integer> answerSet = new HashSet<>(Arrays.asList(answers));
        intersectionSet.retainAll(answerSet);
        return intersectionSet.size() - strike;
    }

    private int getStrike(Integer[] inputNums) {
        int strike = 0;
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            if(inputNums[i].equals(answers[i])) {
                strike++;
            }
        }
        return strike;
    }

}
