package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberTest {

    @DisplayName("숫자 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,5,6,9})
    void create(int expected) {
        Number actual = Number.valueOf(expected);
        assertThat(actual.getNumber()).isEqualTo(expected);
    }

    @DisplayName("숫자 범위 벗어날 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0,-1,10,100})
    void createInvalid(int expected) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                                                            () -> Number.valueOf(expected));
        assertThat(exception.getMessage()).isEqualTo("유효하지 않은 범위의 숫자입니다.");
    }
}
