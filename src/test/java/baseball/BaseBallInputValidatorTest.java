package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomNumberGeneratorStub;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallInputValidatorTest {
    private BaseBallGame baseBallGame;

    @BeforeEach
    void setUp() {
        baseBallGame = new BaseBallGame(new RandomNumberGeneratorStub("369"));
    }

    @DisplayName("입력 문자열의 길이가 3글자를 넘을 경우 오류 체크 테스트")
    @Test
    void check_input_argument_length() {
        checkThrowException("12386");

    }

    @DisplayName("입력 문자열에 숫자 이외의 값이 있을 경우 오류 체크 테스트")
    @Test
    void check_input_illegalArgument() {
        checkThrowException("2e3");
    }

    @DisplayName("입력 문자열에 중복 값이 있을 경우 오류 체크 테스트")
    @Test
    void check_input_duplicate_number() {
        checkThrowException("112");
    }

    private void checkThrowException(String input) {
        assertThatThrownBy(() -> {
            baseBallGame.guess(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 중복되지 않은 세자리의 숫자여야 합니다.");
    }
}