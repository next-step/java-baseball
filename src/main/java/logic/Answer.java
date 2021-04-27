package logic;

import process.GameResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Answer {
    public static final int ANSWER_SIZE = 3;
    public static final int ANSWER_LOWER_BOUND_NUMBER = 1;
    public static final int ANSWER_UPPER_BOUND_NUMBER = 9;

    private List<Integer> answer;
    private Set<Integer> answerSet;

    public Answer() {
        generateAnswer();
    }

    public void generateAnswer() {
        answer = new ArrayList<>();
        answerSet = new HashSet<>();
        for (int i = 0; i < ANSWER_SIZE; i++) {
            int generatedRandomValue = generateNotDuplicatedRandomValue(ANSWER_LOWER_BOUND_NUMBER, ANSWER_UPPER_BOUND_NUMBER, answerSet);
            answer.add(generatedRandomValue);
            answerSet.add(generatedRandomValue);
        }
    }

    private int generateNotDuplicatedRandomValue(int min, int max, Set<Integer> answerSet) {
        int number;
        do {
            number = ThreadLocalRandom.current().nextInt(min, max + 1);
        } while (answerSet.contains(number));
        return number;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public GameResult calculateResult(List<Integer> question) {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < Answer.ANSWER_SIZE; i++) {
            gameResult.applyJudgment(judge(question, i));
        }
        return gameResult;
    }

    private int judge(List<Integer> question, int i) {
        if (isCompletelySame(question, i)) return GameResult.STRIKE;
        if (isValueExist(question.get(i))) return GameResult.BALL;
        return GameResult.NOTHING;
    }

    private boolean isValueExist(int value) {
        return answerSet.contains(value);
    }

    private boolean isCompletelySame(List<Integer> question, int i) {
        return question.get(i) == (answer.get(i));
    }

    public static List<Integer> convertStringToAnswerFormat(String inputValue) {
        List<Integer> formattedValue = new ArrayList<>();
        for (int i = 0; i < inputValue.length(); i++) {
            formattedValue.add(Integer.parseInt(String.valueOf(inputValue.charAt(i))));
        }
        return formattedValue;
    }

}
