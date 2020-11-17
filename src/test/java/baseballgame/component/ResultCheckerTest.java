package baseballgame.component;

import baseballgame.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultCheckerTest {

    @DisplayName("스트라이크와 볼 카운트 체크")
    @ParameterizedTest
    @MethodSource("provideInputList")
    void check_strike_and_ball_count(int expectedStrikeCount, int expectedBallCount, List<Integer> input) {
        //given
        List<Integer> answer = Arrays.asList(1, 2, 3);

        //when
        Result result = ResultChecker.getInstance().check(input, answer);
        int strikeCount = result.getStrikeCount();
        int ballCount = result.getBallCount();

        //then
        assertThat(strikeCount).isEqualTo(expectedStrikeCount);
        assertThat(ballCount).isEqualTo(expectedBallCount);
    }

    static Stream<Arguments> provideInputList() {
        return Stream.of(
                Arguments.of(0, 0, Arrays.asList(7, 8, 9)),
                Arguments.of(1, 0, Arrays.asList(1, 8, 9)),
                Arguments.of(2, 0, Arrays.asList(1, 2, 9)),
                Arguments.of(3, 0, Arrays.asList(1, 2, 3)),
                Arguments.of(0, 1, Arrays.asList(7, 8, 1)),
                Arguments.of(0, 2, Arrays.asList(7, 1, 2)),
                Arguments.of(0, 3, Arrays.asList(3, 1, 2)),
                Arguments.of(1, 1, Arrays.asList(1, 7, 2)),
                Arguments.of(1, 2, Arrays.asList(1, 3, 2))
        );
    }


}