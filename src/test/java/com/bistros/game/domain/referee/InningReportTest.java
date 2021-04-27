package com.bistros.game.domain.referee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.bistros.game.domain.referee.InningReport.HIT.BALL;
import static com.bistros.game.domain.referee.InningReport.HIT.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

class InningReportTest {

    @Test
    @DisplayName("힌트 출력 테스트 - 2 스트라이크")
    void check_print_hint_2_0() {
        InningReport report = new InningReport(Arrays.asList(STRIKE, STRIKE));

        assertThat(report.getHint()).isEqualTo("2 스트라이크");
    }


    @Test
    @DisplayName("힌트 출력 테스트 - 1 스트라이크 2볼")
    void check_print_hint_1_2() {
        InningReport report = new InningReport(Arrays.asList(STRIKE, BALL, BALL));

        assertThat(report.getHint()).isEqualTo("1 스트라이크 2 볼");
    }

    @Test
    @DisplayName("힌트 출력 테스트 -  2볼")
    void check_print_hint_0_2() {
        InningReport report = new InningReport(Arrays.asList(BALL, BALL));

        assertThat(report.getHint()).isEqualTo("2 볼");
    }

    @Test
    @DisplayName("힌트 출력 테스트 -  낫싱")
    void check_print_hint_0_0() {
        InningReport report = new InningReport(Collections.emptyList());

        assertThat(report.getHint()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("힌트 출력 테스트 -  3 스트라이크")
    void check_print_hint_3_0() {
        InningReport report = new InningReport(Arrays.asList(STRIKE, STRIKE, STRIKE));

        assertThat(report.getHint()).isEqualTo("3 스트라이크");
    }

}