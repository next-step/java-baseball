package baseball.domain;

import baseball.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private final List<BaseballNumber> answer;

    private Answer(final List<BaseballNumber> answer) {
        this.answer = answer;
    }

    public static Answer from(final NumberGenerator numberGenerator) {
        List<BaseballNumber> answer = new ArrayList<>();
        for (Integer number : numberGenerator.generator()) {
            answer.add(BaseballNumber.from(number));
        }
        return new Answer(answer);
    }

    public BaseballNumber getAnswer(final int index) {
        return answer.get(index);
    }
}
