package nextstep.precourse.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.precourse.domain.BallNumber.BALLNUMBER_NUMBER_INVALID_MESSAGE;
import static nextstep.precourse.domain.BallNumber.BALLNUMBER_POSITION_INVALID_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BallNumberTest {
    public static final BallNumber BALLNUMBER_ONE = new BallNumber(1, 1);
    public static final BallNumber BALLNUMBER_TWO = new BallNumber(2, 2);
    public static final BallNumber BALLNUMBER_THREE = new BallNumber(3, 3);
    public static final BallNumber BALLNUMBER_FOUR = new BallNumber(4, 1);
    public static final BallNumber BALLNUMBER_FIVE = new BallNumber(5, 2);
    public static final BallNumber BALLNUMBER_SIX = new BallNumber(6, 3);
    public static final BallNumber BALLNUMBER_SAME_POSITION = new BallNumber(4, 2);
    public static final BallNumber BALLNUMBER_SAME_NUMBER = new BallNumber(2, 3);

    @Test
    @DisplayName("Ball Number의 숫자는 1~9 중 하나여야 한다. 그렇지 않을 경우 Exception을 반환한다.")
    void assertNumber() {
        int ballNumberZero = 0;
        int ballNumberTen = 10;
        int ballPosition = 3;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumber(ballNumberZero, ballPosition);
        }).withMessage(BALLNUMBER_NUMBER_INVALID_MESSAGE);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumber(ballNumberTen, ballPosition);
        }).withMessage(BALLNUMBER_NUMBER_INVALID_MESSAGE);
    }

    @Test
    @DisplayName("Ball Number의 포지션은 1, 2, 3 중 하나여야 한다. 그렇지 않을 경우 Exception을 반환한다.")
    void assertPosition() {
        int ballNumber = 1;
        int ballPositionZero = 0;
        int ballPositionFour = 4;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumber(ballNumber, ballPositionZero);
        }).withMessage(BALLNUMBER_POSITION_INVALID_MESSAGE);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumber(ballNumber, ballPositionFour);
        }).withMessage(BALLNUMBER_POSITION_INVALID_MESSAGE);
    }

    @Test
    @DisplayName("해당 숫자의 포지션이 입력받은 포지션과 일치하는지 판단한다.")
    void isPosition() {
        assertThat(BALLNUMBER_ONE.isPosition(1)).isTrue();
        assertThat(BALLNUMBER_TWO.isPosition(3)).isFalse();
    }

    @Test
    @DisplayName("해당 숫자가 입력받은 숫자와 일치하는지 판단한다.")
    void isNumber() {
        assertThat(BALLNUMBER_ONE.isNumber(1)).isTrue();
        assertThat(BALLNUMBER_TWO.isNumber(3)).isFalse();
    }
}
