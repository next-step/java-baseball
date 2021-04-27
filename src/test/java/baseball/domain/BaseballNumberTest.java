package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseballNumberTest {

    @Test
    @DisplayName("숫자 정상생성")
    void create() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(1);

        // when then
        assertThat(baseballNumber.match(1)).isTrue();
    }

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
    @DisplayName("숫자 비교 검증")
    void equals() {
        // given
        BaseballNumber base = new BaseballNumber(1);
        BaseballNumber targetEqual = new BaseballNumber(1);
        BaseballNumber targetNotEqual = new BaseballNumber(2);

        // when then
        assertAll(
                () -> assertThat(base.equals(targetEqual)).isTrue(),
                () -> assertThat(base.equals(targetNotEqual)).isFalse()
        );
    }

}