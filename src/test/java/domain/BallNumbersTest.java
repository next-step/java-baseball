package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BallNumbersTest {

    @DisplayName("유저가 규정에 맞게 입력한 숫자를 정확하게 생성하는지 확인")
    @Test
    void createBallNumbersTest() {
        BallNumbers ballNumbers = BallNumbers.of("123");
//        assertThat(ballNumbers).isEqualTo(new )
    }

    @DisplayName("유저가 입력한 숫자가 중복된 숫자를 가지고 있을때 에러를 잘 던지는지 확인")
    @Test
    void checkUniqueNumbersTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> BallNumbers.of("113"));
    }

    @DisplayName("유저가 세자리 숫자를 가지고 있지 않을때 에러를 잘 던지는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"13", "1345", "1344"})
    void checkCorrectSizeTest(String numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> BallNumbers.of(numbers));
    }
}