package baseball.generator;

import baseball.constants.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnswerGenerator implements NumberGenerator {
    private static final List<Integer> baseballNumbers;

    static {
        baseballNumbers = new ArrayList<>();
        for (int i = Constants.BASEBALL_NUMBER_MIN_BOUND; i <= Constants.BASEBALL_NUMBER_MAX_BOUND; i++) {
            baseballNumbers.add(Integer.valueOf(i));
        }
    }

    @Override
    public List<Integer> generator() {
        Collections.shuffle(baseballNumbers);
        return getAnswer();
    }

    private List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < Constants.BASEBALL_NUMBER_SIZE; i++) {
            answer.add(baseballNumbers.get(i));
        }
        return answer;
    }
}
