package app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    private static Stream<Arguments> getMockData() {
        return Stream.of(
                Arguments.of("369", "111", "낫싱"),
                Arguments.of("369", "312", "1 스트라이크"),
                Arguments.of("369", "119", "1 스트라이크"),
                Arguments.of("369", "367", "2 스트라이크"),
                Arguments.of("369", "936", " 3 볼"),
                Arguments.of("369", "391", "1 스트라이크 1 볼"),
                Arguments.of("369", "369", "3 스트라이크")
        );
    }

    @ParameterizedTest(name = "임의생성값 [{0}], 입력값 [{1}], 카운트 결과 [{2}]")
    @MethodSource("getMockData")
    void guess(String generateNumber, String inputNumber, String resultMessage) {
        BaseballGame baseballGame = new BaseballGame(generateNumber);
        Score score = baseballGame.guess(inputNumber);

        assertThat(score.getResultMessage()).isEqualTo(resultMessage);

    }
}