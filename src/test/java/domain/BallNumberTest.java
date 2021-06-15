package domain;

import domain.exception.BallNumberNotValidRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumberTest {

    @Test
    @DisplayName("볼 넘버 생성 시 음수 입력하면 예외처리 한다.")
    public void test() {
        int number = -1;

        assertThatThrownBy(() -> {
            BallNumber.valueOf(number);
        }).isExactlyInstanceOf(BallNumberNotValidRangeException.class)
                .hasMessage(BallNumberNotValidRangeException.ERROR_MESSAGE);
    }


    @Test
    @DisplayName("볼 넘버 생성 시 0 입력하면 예외처리 한다.")
    public void test0() {
        int number = 0;

        assertThatThrownBy(() -> {
            BallNumber.valueOf(number);
        }).isExactlyInstanceOf(BallNumberNotValidRangeException.class)
                .hasMessage(BallNumberNotValidRangeException.ERROR_MESSAGE);
    }

    @Test
    @DisplayName("볼 넘버 생성 시 10이상의 값을 입력하면 예외처리 한다.")
    public void test1() {
        int number = 10;

        assertThatThrownBy(() -> {
            BallNumber.valueOf(number);
        }).isExactlyInstanceOf(BallNumberNotValidRangeException.class)
                .hasMessage(BallNumberNotValidRangeException.ERROR_MESSAGE);
    }

    @Test
    @DisplayName("볼 넘버 생성 시 1~9 사이의 값입력 시 정상적으로 생성 된다.")
    public void test2() {
        for (int number = BallNumber.MIN_BALL_NUMBER; number < BallNumber.MAX_BALL_NUMBER; number++) {
            BallNumber ballNumber = BallNumber.valueOf(number);
            assertThat(number).isEqualTo(ballNumber.number());
        }
    }
}