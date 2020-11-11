package nextstep.precourse.domain;

import nextstep.precourse.domain.BallNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BallNumberTest {

    @Test
    @DisplayName("Ball Number의 숫자는 1~9 중 하나여야 한다. 그렇지 않을 경우 Exception을 반환한다.")
    void assertNumber() {
        int ballNumberZero = 0;
        int ballNumberTen = 10;
        int ballPosition = 3;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumber(ballNumberZero, ballPosition);
        }).withMessage("1에서 9사이의 숫자여야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumber(ballNumberTen, ballPosition);
        }).withMessage("1에서 9사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("Ball Number의 포지션은 1, 2, 3 중 하나여야 한다. 그렇지 않을 경우 Exception을 반환한다.")
    void assertPosition() {
        int ballNumber = 1;
        int ballPositionZero = 0;
        int ballPositionFour = 4;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumber(ballNumber, ballPositionZero);
        }).withMessage("1에서 9사이의 숫자여야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumber(ballNumber, ballPositionFour);
        }).withMessage("1에서 9사이의 숫자여야 합니다.");
    }
}
