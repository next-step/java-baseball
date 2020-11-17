package domain;

import domain.SourceNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SourceNumbersTest {

    @ParameterizedTest
    @DisplayName("Source 숫자 생성 테스트")
    @MethodSource
    void generate_source_number(BaseBallNumber baseBallNumber) {

        // given
        List<BaseBallNumber> sourceBallNumbers = SourceNumbers.getSourceBallNumbers();

        // when & then
        assertThat(sourceBallNumbers).contains(baseBallNumber);
    }

    static Stream<Arguments> generate_source_number() {
        return Stream.of(
                arguments(new BaseBallNumber(1)),
                arguments(new BaseBallNumber(2)),
                arguments(new BaseBallNumber(3)),
                arguments(new BaseBallNumber(4)),
                arguments(new BaseBallNumber(5)),
                arguments(new BaseBallNumber(6)),
                arguments(new BaseBallNumber(7)),
                arguments(new BaseBallNumber(8)),
                arguments(new BaseBallNumber(9))
        );
    }

    @ParameterizedTest
    @DisplayName("Source 숫자 가져오기 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void get_source_ball_test (int ballNumber) {

        // given
        BaseBallNumber baseBallNumber = SourceNumbers.getBall(ballNumber);

        // when & then
        assertThat(baseBallNumber).isEqualTo(new BaseBallNumber(ballNumber));
    }

    @ParameterizedTest
    @DisplayName("Source 숫자 범위 유효성 테스트")
    @ValueSource(ints = {-10, -1, 11, 20})
    void validate_source_number_range (int input) {
        assertThatThrownBy(() -> {
            SourceNumbers.getBall(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1~9까지만 가능합니다.");
    }
}
