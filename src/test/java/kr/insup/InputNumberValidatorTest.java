package kr.insup;

import kr.insup.domain.InputNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputNumberValidatorTest {

    private static Stream<Arguments> provideNumbersAndExpected() {
        return Stream.of(
                Arguments.of("123", true),
                Arguments.of("345", true),
                Arguments.of("635", true),
                Arguments.of("1234", false),
                Arguments.of("12", false),
                Arguments.of("102", false),
                Arguments.of("12s34", false),
                Arguments.of("034", false),
                Arguments.of("as2e", false),
                Arguments.of("999", false),
                Arguments.of("131", false)
        );
    }

    @DisplayName("입력한 숫자가 유효한 숫자인지 확인")
    @ParameterizedTest
    @MethodSource("provideNumbersAndExpected")
    void 입력숫자_유효성_확인(String number, boolean expected) {
        //given
        //when
        boolean validation = InputNumberValidator.validateNumber(number);
        //then
        assertThat(validation).isEqualTo(expected);
    }
}
