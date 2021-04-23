import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseBall {
    private static final List<Integer> DEFAULT_RANGE = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final int DEFAULT_LENGTH = 3;

    private List<Integer> answer;

    public BaseBall() {
        this.answer = makeAnswer();
    }

    public BaseBall(List<Integer> answer) {
        this.answer = answer;
    }

    public static List<Integer> makeAnswer() {
        List<Integer> copy = new ArrayList<>(DEFAULT_RANGE);
        Collections.shuffle(copy);
        return copy.subList(0, DEFAULT_LENGTH);
    }

    public BaseBallDto.Result getUserResult(List<Integer> userAnswer) {
        int strike = getStrike(userAnswer);
        int ball = getBall(userAnswer) - strike;
        boolean isAnswer = strike == this.answer.size();

        return new BaseBallDto.Result(isAnswer, strike, ball);
    }

    public boolean finish(boolean isFinish) {
        if (!isFinish) {
            refresh();
        }

        return isFinish;
    }

    private void refresh() {
        answer = makeAnswer();
    }

    private int getBall(List<Integer> userAnswer) {
        int ball = 0;

        for (int i = 0; i < answer.size(); ++i) {
            if (answer.contains(userAnswer.get(i))) {
                ++ball;
            }
        }

        return ball;
    }

    private int getStrike(List<Integer> userAnswer) {
        int strike = 0;

        for (int i = 0; i < answer.size(); ++i) {
            if (answer.get(i).equals(userAnswer.get(i))) {
                ++strike;
            }
        }

        return strike;
    }
}
