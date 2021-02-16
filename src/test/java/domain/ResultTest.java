package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    @DisplayName("결과 값을 잘 가지고 오는지 확인한다.")
    @ParameterizedTest
    @MethodSource("providerGetResultTestParam")
    void getResultTest(Result result, int count, String expected) {
        assertThat(result.getResult(count)).isEqualTo(expected);
    }

    private static Stream<Arguments> providerGetResultTestParam() {
        return Stream.of(
                Arguments.of(Result.STRIKE, 1, "1스트라이크"),
                Arguments.of(Result.STRIKE, 0, "")
        );
    }


}