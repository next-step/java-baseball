package nextstep.precourse.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static nextstep.precourse.domain.BallNumberTest.*;
import static nextstep.precourse.domain.BallNumbers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BallNumbersTest {

    @Test
    @DisplayName("BallNumber는 3개만으로 구성되어야 한다. 그렇지 않으면 Exception을 반환한다.")
    void assertCount() {
        List<BallNumber> ballNumberList= new ArrayList<>();
        ballNumberList.add(BALLNUMBER_ONE);
        ballNumberList.add(BALLNUMBER_TWO);
        ballNumberList.add(BALLNUMBER_THREE);
        ballNumberList.add(BALLNUMBER_SAME_POSITION);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumbers(ballNumberList);
        }).withMessage(BALLNUMBERS_COUNT_INVALID_MESSAGE);
    }

    @Test
    @DisplayName("BallNumber는 1,2,3 각각 다른 포지션에 포진되어 있어야 한다. 그렇지 않으면 Exception을 반환한다.")
    void assertPosition() {
        List<BallNumber> ballNumberList = new ArrayList<>();
        ballNumberList.add(BALLNUMBER_ONE);
        ballNumberList.add(BALLNUMBER_TWO);
        ballNumberList.add(BALLNUMBER_SAME_POSITION);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumbers(ballNumberList);
        }).withMessage(BALLNUMBERS_POSITION_INVALID_MESSAGE);
    }

    @Test
    @DisplayName("BallNumber 서로 다른 숫자로 구성되어 있어야 한다. 그렇지 않으면 Exception을 반환한다.")
    void assertNumber() {
        List<BallNumber> ballNumberList = new ArrayList<>();
        ballNumberList.add(BALLNUMBER_ONE);
        ballNumberList.add(BALLNUMBER_TWO);
        ballNumberList.add(BALLNUMBER_SAME_NUMBER);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new BallNumbers(ballNumberList);
        }).withMessage(BALLNUMBERS_NUMBER_INVALID_MESSAGE);
    }

    @Test
    @DisplayName("position을 입력받아 해당되는 숫자를 반환한다.")
    void getNumberByPosition() {
        List<BallNumber> ballNumberList = new ArrayList<>();
        ballNumberList.add(BALLNUMBER_ONE);
        ballNumberList.add(BALLNUMBER_TWO);
        ballNumberList.add(BALLNUMBER_THREE);

        BallNumbers ballNumbers = new BallNumbers(ballNumberList);

        assertThat(ballNumbers.getNumberByPosition(1)).isEqualTo(1);
        assertThat(ballNumbers.getNumberByPosition(3)).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자를 입력받아, 해당 숫자가 BallNumbers에 포함되는지 여부를 확인한다.")
    void isContain() {
        List<BallNumber> ballNumberList = new ArrayList<>();
        ballNumberList.add(BALLNUMBER_ONE);
        ballNumberList.add(BALLNUMBER_TWO);
        ballNumberList.add(BALLNUMBER_THREE);

        BallNumbers ballNumbers = new BallNumbers(ballNumberList);

        assertThat(ballNumbers.isContain(1)).isTrue();
        assertThat(ballNumbers.isContain(4)).isFalse();
    }
}
