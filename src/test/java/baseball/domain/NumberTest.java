package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("0-9까지 범위 숫자를 입력하는 테스트")
    void inputNumberSucceessTest(int number) {
        assertThat(new Number(number).number()).isEqualTo(number);
    }

    @Test
    @DisplayName("0-9범위를 넘어가는 숫자 입력하는 테스트 ")
    void inputNumberOverRangeTest() {
        assertThatThrownBy(() -> {
            new Number(10);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자범위는 0-9까지 입니다.");
    }
}
