package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("야구 번호 테스트")
class BaseballNumberTest {

    @DisplayName("야구 번호 생성 테스트")
    @Test
    void create() {
        BaseballNumber actual = new BaseballNumber(1);
        BaseballNumber expected = new BaseballNumber(1);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("야구 번호 생성 테스트: 1 ~ 9 이외의 값 설정 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = { 0, 10, 15 })
    void validate_number(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumber(number));
    }

}
