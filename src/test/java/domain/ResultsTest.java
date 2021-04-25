package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ResultsTest {

    @ParameterizedTest
    @MethodSource("provideListForIsNullOrEmptyOrHasNull")
    @DisplayName("Results 가 null 이거나 비어 있거나 null 을 포함하는 경우 예외 발생")
    void validateNullOrEmptyOrHasNullTest(List<Result> results) {

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Results.of(results))
                .withMessage("결과 값이 존재하지 않습니다.");
    }

    @ParameterizedTest
    @MethodSource("provideListForResultsAndCountData")
    @DisplayName("유효한 results 입력 시 strike, ball, nothing 카운팅")
    void statisticsTest(List<Result> validResults, int strikeCount, int ballCount) {

        // when
        Results results = Results.of(validResults);

        // then
        assertThat(results.getNumberOfStrike()).isEqualTo(strikeCount);
        assertThat(results.getNumberOfBall()).isEqualTo(ballCount);
    }

    @ParameterizedTest
    @MethodSource("provideListForResultData")
    @DisplayName("유효한 results 입력 시 결과 메시지 생성")
    void test(List<Result> validResults, String resultMessage) {
        // when
        Results results = Results.of(validResults);

        // then
        assertThat(results.createResultMessage()).contains(resultMessage);
    }

    private static Stream<List<Result>> provideListForIsNullOrEmptyOrHasNull() {
        return Stream.of(
                null, Collections.emptyList(), Arrays.asList(Result.STRIKE, null)
        );
    }

    private static Stream<Arguments> provideListForResultsAndCountData() {
        return Stream.of(
                Arguments.of(Arrays.asList(Result.STRIKE, Result.STRIKE, Result.BALL), 2, 1),
                Arguments.of(Arrays.asList(Result.STRIKE, Result.BALL, Result.BALL), 1, 2),
                Arguments.of(Arrays.asList(Result.STRIKE, Result.STRIKE, Result.STRIKE), 3, 0),
                Arguments.of(Arrays.asList(Result.NOTHING, Result.STRIKE, Result.BALL), 1, 1)
        );
    }

    private static Stream<Arguments> provideListForResultData() {
        return Stream.of(
                Arguments.of(Arrays.asList(Result.STRIKE, Result.STRIKE, Result.BALL), "2 스트라이크 1 볼"),
                Arguments.of(Arrays.asList(Result.STRIKE, Result.BALL, Result.BALL), "1 스트라이크 2 볼"),
                Arguments.of(Arrays.asList(Result.STRIKE, Result.STRIKE, Result.STRIKE), "3 스트라이크"),
                Arguments.of(Arrays.asList(Result.NOTHING, Result.STRIKE, Result.BALL), "1 스트라이크 1 볼")
        );
    }
}