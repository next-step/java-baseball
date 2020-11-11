package nextstep.precourse.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static nextstep.precourse.domain.BallNumbers.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BallNumbersTest {
    private static final BallNumber BALLNUMBER_ONE = new BallNumber(1, 1);
    private static final BallNumber BALLNUMBER_TWO = new BallNumber(2, 2);
    private static final BallNumber BALLNUMBER_THREE = new BallNumber(3, 3);
    private static final BallNumber BALLNUMBER_SAME_POSITION = new BallNumber(4, 2);
    private static final BallNumber BALLNUMBER_SAME_NUMBER = new BallNumber(2, 3);

    @Test
    @DisplayName("BallNumber는 3개만으로 구성되어야 한다. 그렇지 않으면 Exception을 반환한다.")
    void assertCount() {
        List<BallNumber> ballNumbers= new ArrayList<>();
        ballNumbers.add(BALLNUMBER_ONE);
        ballNumbers.add(BALLNUMBER_TWO);
        ballNumbers.add(BALLNUMBER_THREE);
        ballNumbers.add(BALLNUMBER_SAME_POSITION);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumbers(ballNumbers);
        }).withMessage(BALLNUMBERS_COUNT_INVALID_MESSAGE);
    }

    @Test
    @DisplayName("BallNumber는 1,2,3 각각 다른 포지션에 포진되어 있어야 한다. 그렇지 않으면 Exception을 반환한다.")
    void assertPosition() {
        List<BallNumber> ballNumbers = new ArrayList<>();
        ballNumbers.add(BALLNUMBER_ONE);
        ballNumbers.add(BALLNUMBER_TWO);
        ballNumbers.add(BALLNUMBER_SAME_POSITION);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumbers(ballNumbers);
        }).withMessage(BALLNUMBERS_POSITION_INVALID_MESSAGE);
    }

    @Test
    @DisplayName("BallNumber 서로 다른 숫자로 구성되어 있어야 한다. 그렇지 않으면 Exception을 반환한다.")
    void assertNumber() {
        List<BallNumber> ballNumbers = new ArrayList<>();
        ballNumbers.add(BALLNUMBER_ONE);
        ballNumbers.add(BALLNUMBER_TWO);
        ballNumbers.add(BALLNUMBER_SAME_NUMBER);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumbers(ballNumbers);
        }).withMessage(BALLNUMBERS_NUMBER_INVALID_MESSAGE);
    }
}
