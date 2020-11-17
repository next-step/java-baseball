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

    public GameResult judge(Integer[] inputNums) {
        int strike = 0;
        int ball = 0;

        Set<Integer> inputSet = new HashSet<>(Arrays.asList(inputNums));
        Set<Integer> answerSet = new HashSet<>(Arrays.asList(answers));

        for (int i = 0; i < ANSWER_LENGTH; i++) {
            Integer inputNum = inputNums[i];
            Integer answer = answers[i];
            if(inputNum.equals(answer)) {
                strike++;
                inputSet.remove(inputNum);
                answerSet.remove(answer);
            }
        }

        inputSet.retainAll(answerSet);
        ball = inputSet.size();

        return new GameResult(strike, ball);
    }

}
