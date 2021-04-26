package baseball.domain;

import baseball.generator.TestAnswerGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AnswerTest {

    @DisplayName("정답이 생성됐을때 index에 해당하는 BaseballNumber를 반환한다")
    @Test
    void getAnswer() {
        // given
        Answer answer = Answer.from(new TestAnswerGenerator());

        // when
        BaseballNumber firstBaseballNumber = answer.getAnswer(0);
        BaseballNumber secondBaseballNumber = answer.getAnswer(1);
        BaseballNumber thirdBaseballNumber = answer.getAnswer(2);

        // then
        assertAll(
                () -> assertThat(firstBaseballNumber).isEqualTo(BaseballNumber.from(1)),
                () -> assertThat(secondBaseballNumber).isEqualTo(BaseballNumber.from(2)),
                () -> assertThat(thirdBaseballNumber).isEqualTo(BaseballNumber.from(3))
        );
    }
}