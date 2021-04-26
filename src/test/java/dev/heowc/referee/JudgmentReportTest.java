package dev.heowc.referee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("판정 보고서에 대해 테스트한다.")
class JudgmentReportTest {

    @DisplayName("1개 판정에 대한 개수를 증가시킬 수 있다.")
    @Test
    void increment() {
        final JudgmentReport report = JudgmentReport.empty();
        for (Judgment judgment : Judgment.values()) {
            report.increment(judgment);
        }
        assertThat(report.count(Judgment.STRIKE)).isEqualTo(1);
        assertThat(report.count(Judgment.BALL)).isEqualTo(1);
        assertThat(report.count(Judgment.MISS)).isEqualTo(1);
    }

    @DisplayName("완료 상태 여부를 확인할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideIsCompletedMethodArguments")
    void isCompleted(List<Judgment> judgmentList, boolean isCompleted) {
        final JudgmentReport report = JudgmentReport.empty();
        for (Judgment judgment : judgmentList) {
            report.increment(judgment);
        }
        assertThat(report.isCompleted()).isEqualTo(isCompleted);
    }

    private static Stream<? extends Arguments> provideIsCompletedMethodArguments() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(Judgment.STRIKE, Judgment.STRIKE, Judgment.STRIKE),
                        true
                ),
                Arguments.of(
                        Arrays.asList(Judgment.STRIKE, Judgment.STRIKE, Judgment.BALL),
                        false
                ),
                Arguments.of(
                        Arrays.asList(Judgment.STRIKE, Judgment.STRIKE, Judgment.MISS),
                        false
                )
        );
    }

    @DisplayName("힌트를 가져올 수 있다.")
    @ParameterizedTest
    @MethodSource("providePrettyHintMethodArguments")
    void prettyHint(List<Judgment> judgmentList, String expected) {
        final JudgmentReport report = JudgmentReport.empty();
        for (Judgment judgment : judgmentList) {
            report.increment(judgment);
        }
        assertThat(report.prettyHint()).isEqualTo(expected);
    }

    private static Stream<? extends Arguments> providePrettyHintMethodArguments() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(Judgment.STRIKE, Judgment.STRIKE, Judgment.STRIKE),
                        "3 스트라이크"
                ),
                Arguments.of(
                        Arrays.asList(Judgment.STRIKE, Judgment.STRIKE, Judgment.BALL),
                        "2 스트라이크 1 볼"
                ),
                Arguments.of(
                        Arrays.asList(Judgment.STRIKE, Judgment.STRIKE, Judgment.MISS),
                        "2 스트라이크"
                ),
                Arguments.of(
                        Arrays.asList(Judgment.BALL, Judgment.BALL, Judgment.MISS),
                        "2 볼"
                ),
                Arguments.of(
                        Arrays.asList(Judgment.MISS, Judgment.MISS, Judgment.MISS),
                        "낫싱"
                )
        );
    }
}
