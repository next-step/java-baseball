package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerNumberTest {

    @RepeatedTest(100)
    @DisplayName("3자리의 숫자를 생성한다.")
    void makeAnswerNumberTest() {
        AnswerNumber answerNumber = AnswerNumber.init();

        assertThat(answerNumber.getNumber())
                .isBetween(100, 999);
    }
}