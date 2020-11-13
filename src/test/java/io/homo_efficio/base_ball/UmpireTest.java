package io.homo_efficio.base_ball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UmpireTest {

    @ParameterizedTest(name = "컴퓨터 생성값 [{0}], 입력값 [{1}], 판정 결과 [{2}]")
    @MethodSource("getGenAndInput")
    void umpire_judge(String genNumber, String inputNumber, String resultText) {
        Umpire umpire = new Umpire(genNumber, inputNumber);
        Result result = umpire.judge();
        assertThat(result.getText()).isEqualTo(resultText);
    }

    private static Stream<Arguments> getGenAndInput() {
        return Stream.of(
                Arguments.of("713", "123", "1 스트라이크 1 볼"),
                Arguments.of("713", "145", "1 볼"),
                Arguments.of("713", "671", "2 볼"),
                Arguments.of("713", "216", "1 스트라이크"),
                Arguments.of("713", "713", "3 스트라이크")
        );
    }
}
