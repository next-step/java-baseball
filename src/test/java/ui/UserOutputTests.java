package ui;

import domain.BaseballResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UserOutputTests {
    @DisplayName("야구게임 1회 진행 결과를 출력할 수 있다.")
    @ParameterizedTest
    @MethodSource("parseBaseballGameResultResource")
    void parseBaseballGameResultTest(BaseballResult baseballResult, String expectedResult) {
        assertThat(UserOutput.parseResult(baseballResult)).isEqualTo(expectedResult);
    }
    public static Stream<Arguments> parseBaseballGameResultResource() {
        return Stream.of(
                Arguments.of(BaseballResult.makeFourBall(), "포볼입니다.(맞춘 공이 없습니다.)"),
                Arguments.of(BaseballResult.of(1, 0), "1 볼"),
                Arguments.of(BaseballResult.of(1, 1), "1 볼 / 1 스트라이크"),
                Arguments.of(BaseballResult.of(0, 1), "1 스트라이크"),
                Arguments.of(BaseballResult.of(0, 3), "3 스트라이크")
        );
    }
}
