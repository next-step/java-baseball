package domain.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @Test
    @DisplayName("서로다른 3가지 숫자가 중복없이 랜덤으로 생성되는지 확인")
    void generate_three_number() {

        // given
        NumberGenerator numberGenerator1 = NumberGenerator.newInstance();
        NumberGenerator numberGenerator2 = NumberGenerator.newInstance();

        // when
        List<Integer> answer1 = numberGenerator1.getAnswer();
        List<Integer> answer2 = numberGenerator2.getAnswer();

        // then
        assertEquals(answer1.stream()
                .distinct()
                .count(), 3);
        assertEquals(answer2.stream()
                .distinct()
                .count(), 3);
        assertThat(answer1)
                .isNotIn(answer2);
    }
}