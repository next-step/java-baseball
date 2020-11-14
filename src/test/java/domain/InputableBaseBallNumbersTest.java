package domain;

import exception.DuplicatedBBNException;
import exception.OutOfSizeBBNException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputableBaseBallNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "12",
            "1111",
            "12345",
    })
    @DisplayName("자릿수가 3자리가 아니면 예외가 발생한다.")
    void outOfSizeTest(String input) {
        assertThrows(OutOfSizeBBNException.class, () -> {
            BaseBallNumbers baseBallNumbers = new InputableBaseBallNumbers(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123",
            "456",
            "789",
            "912",
            "253",
    })
    @DisplayName("입력받은 인풋 문자열로 BaseBallNumbers을 생성하면 값이 잘 들어가고, 이 값들은 1 ~ 9 범위에 유효하다.")
    void insertInputToInputableBaseBallNumbersTest(String input) {
        BaseBallNumbers baseBallNumbers = new InputableBaseBallNumbers(input);
        BaseBallNumber[] balls = baseBallNumbers.getBaseBallNumbers();
        char[] inputBalls = input.toCharArray();
        for(int i = 0; i < balls.length; i++) {
            assertThat(balls[i].get()).isEqualTo(inputBalls[i] - '0');
            assertThat(balls[i].get()).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "111",
            "121",
            "919",
            "224",
    })
    @DisplayName("중복된 수가 있을 때 DuplicatedBBNException 예외가 발생한다.")
    void duplicatedTest(String input) {
        assertThrows(DuplicatedBBNException.class, () -> {
            BaseBallNumbers baseBallNumbers = new InputableBaseBallNumbers(input);
        });
    }

}