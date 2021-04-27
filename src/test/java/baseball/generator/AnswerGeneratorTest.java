package baseball.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerGeneratorTest {

    @DisplayName("정답을 생성하면 3자리의 숫자가 생성된다")
    @Test
    void check_size() {
        // given
        List<Integer> answer = new AnswerGenerator().generator();

        // when
        int size = answer.size();

        // then
        assertThat(size).isEqualTo(3);
    }
}
