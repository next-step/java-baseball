package com.jaeeyeonling.baseball.referee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("판정 보고서에 대해 테스트한다.")
class JudgeReportTest {

    private JudgeReport report;

    @BeforeEach
    void setUp() {
        report = JudgeReport.empty();
    }

    @DisplayName("1개 판정에 대한 개수를 증가시킬 수 있다.")
    @ParameterizedTest
    @EnumSource(Judge.class)
    void incrementSingle(final Judge judge) {
        // given
        final var expectCount = 1;

        // when
        report.increment(judge);

        // then
        assertThat(report.getCount(judge)).isEqualTo(expectCount);
    }

    @DisplayName("판정 개수를 가져올 수 있다.")
    @ParameterizedTest
    @EnumSource(Judge.class)
    void getCount(final Judge judge) {
        // given
        final var expectCount = 0;

        // when
        final var count = report.getCount(judge);

        // then
        assertThat(count).isEqualTo(expectCount);
    }

    @DisplayName("완료 상태인지 확인할 수 있다.")
    @ParameterizedTest
    @EnumSource(value = Judge.class, names = "STRIKE", mode = EnumSource.Mode.INCLUDE)
    void isComplete(final Judge judge) {
        // given
        report.increment(judge, judge, judge);

        // when
        final var complete = report.isComplete();

        // then
        assertThat(complete).isTrue();
    }

    @DisplayName("완료 상태가 아닌지 확인할 수 있다.")
    @ParameterizedTest
    @EnumSource(value = Judge.class, names = "STRIKE", mode = EnumSource.Mode.EXCLUDE)
    void notComplete(final Judge judge) {
        // given
        report.increment(judge, judge, judge);

        // when
        final var complete = report.isComplete();

        // then
        assertThat(complete).isFalse();
    }


    @DisplayName("낫싱 상태인지 확인할 수 있다.")
    @ParameterizedTest
    @EnumSource(value = Judge.class, names = "MISS", mode = EnumSource.Mode.INCLUDE)
    void isNothing(final Judge judge) {
        // given
        report.increment(judge, judge, judge);

        // when
        final var nothing = report.isNothing();

        // then
        assertThat(nothing).isTrue();
    }

    @DisplayName("완료 상태가 아닌지 확인할 수 있다.")
    @ParameterizedTest
    @EnumSource(value = Judge.class, names = "MISS", mode = EnumSource.Mode.EXCLUDE)
    void notNothing(final Judge judge) {
        // given
        report.increment(judge, judge, judge);

        // when
        final var nothing = report.isNothing();

        // then
        assertThat(nothing).isFalse();
    }
}
