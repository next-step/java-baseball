package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    @DisplayName("야구숫자 생성 - 범위를 벗어난 숫자")
    void create_invalidNumber(int param) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumber(param))
                .withMessageMatching("야구숫자는 1 과 9 사이의 수 이어야 합니다.");
    }

    @Test
    @DisplayName("숫자 정상생성")
    void create() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(1);

        // when then
        assertThat(baseballNumber.match(1)).isTrue();
    }

}