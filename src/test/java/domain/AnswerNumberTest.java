package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerNumberTest {

    @RepeatedTest(100)
    @DisplayName("3자리의 서로 다른 숫자를 생성한다.")
    void makeAnswerNumberTest() {
        AnswerNumber answerNumber = AnswerNumber.init();

        int number = answerNumber.getNumber();
        assertThat(AnswerNumber.isDuplicateNumberExist(number))
                .isFalse();
        assertThat(number).isBetween(100, 999);
    }

    @ParameterizedTest
    @ValueSource(ints = {111, 112, 121, 211})
    @DisplayName("각 자리수에 같은 숫자가 있는지 검사한다.")
    void duplicateNumberExistTest(int number) {
        assertThat(AnswerNumber.isDuplicateNumberExist(number))
                .isTrue();
    }
}