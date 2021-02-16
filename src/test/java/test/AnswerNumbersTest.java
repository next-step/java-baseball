package test;

import baseball.model.AnswerNumbers;
import baseball.model.strategy.LinearStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerNumbersTest {
    @Test
    @DisplayName("AnswerNumbers를 만들었을 때, 값을 확인하는 테스")
    void getAnswerNumbersTest() {
        final LinearStrategy linearStrategy = new LinearStrategy();
        final AnswerNumbers answerNumbers = new AnswerNumbers(linearStrategy);

        assertThat(answerNumbers.getAnswerNumbers()).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3)));
    }
}