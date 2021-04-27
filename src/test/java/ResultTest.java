import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    @DisplayName("스트라이크 카운트 증가")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void increaseStrikeCountTest(int count) {
        // given
        Result result = new Result();

        // then
        for (int i = 0; i < count; i++) {
            result.increaseStrikeCount();
        }

        // when
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.getStrikeCount()).isEqualTo(count);
    }

    @DisplayName("볼 카운트 증가")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void increaseBallCountTest(int count) {
        // given
        Result result = new Result();

        // then
        for (int i = 0; i < count; i++) {
            result.increaseBallCount();
        }

        // when
        assertThat(result.getBallCount()).isEqualTo(count);
        assertThat(result.getStrikeCount()).isEqualTo(0);
    }

    @DisplayName("낫싱 테스트")
    @Nested
    class NothingTest {

        @DisplayName("스트라이크 0, 볼 0 이면 낫싱 True")
        @Test
        void nothingIsTrue() {
            Result result = new Result();
            assertThat(result.isNothing()).isTrue();
        }

        @DisplayName("스트라이크 카운트가 증가하면 낫싱 False")
        @Test
        void nothingIsFalseIfStrikeCount() {
            Result result = new Result();
            result.increaseStrikeCount();
            assertThat(result.isNothing()).isFalse();
        }

        @DisplayName("볼 카운트가 증가하면 낫싱 False")
        @Test
        void nothingIsFalseIfBallCount() {
            Result result = new Result();
            result.increaseBallCount();
            assertThat(result.isNothing()).isFalse();
        }
    }
}