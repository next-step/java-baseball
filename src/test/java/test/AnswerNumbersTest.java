package test;

import baseball.model.AnswerNumbers;
import baseball.model.strategy.LinearStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnswerNumbersTest {
    @Test
    @DisplayName("AnswerNumbers를 만들었을 때, 값을 확인하는 테스트")
    void getAnswerNumbersTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();
        final AnswerNumbers answerNumbers = new AnswerNumbers(linearStrategy);
        final List<Integer> answerNumberList = answerNumbers.getAnswerNumbers();
        assertThat(answerNumberList).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3)));
    }

    @Test
    @DisplayName("포지션으로 접근할 때, 값을 확인하는 테스트")
    void getAnswerNumberTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();
        final AnswerNumbers answerNumbers = new AnswerNumbers(linearStrategy);

        assertThat(answerNumbers.getAnswerNumber(0)).isEqualTo(1);
        assertThat(answerNumbers.getAnswerNumber(1)).isEqualTo(2);
        assertThat(answerNumbers.getAnswerNumber(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("1이 들어올 때, 정답에 있는 지 확인하는 테스트")
    void containsTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();
        final AnswerNumbers answerNumbers = new AnswerNumbers(linearStrategy);

        boolean isContains = answerNumbers.contains(1);
        assertThat(isContains).isEqualTo(true);
    }

    @Test
    @DisplayName("잘못된 포지션으로 접근시에 에러 확인 테스트")
    void getAnswerNumberErrorTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();
        final AnswerNumbers answerNumbers = new AnswerNumbers(linearStrategy);

        assertThrows(IllegalArgumentException.class, () -> answerNumbers.getAnswerNumber(4));

    }
}