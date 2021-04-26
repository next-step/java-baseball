package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BallTest {
    private List<Integer> twoNumbers;
    private List<Integer> duplicatedNumbers;
    private List<BallNumber> ballNumbers;

    @BeforeEach
    void setUp() {
        ballNumbers = new ArrayList<>();
        twoNumbers = Arrays.asList(1, 2);
        duplicatedNumbers = Arrays.asList(1, 1, 1);
    }

    @DisplayName("볼은 한 번에 숫자 3개로 생성된다.")
    @Test
    void ballCreate() {
        // given
        for (Integer twoNumber : twoNumbers) {
            BallNumber ballNumber = new BallNumber(twoNumber);
            ballNumbers.add(ballNumber);
        }

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(ballNumbers));
    }

    @DisplayName("볼 숫자가 중복없이 생성된다.")
    @Test
    void testDuplicate() {
        for (Integer duplicateNumber : duplicatedNumbers) {
            BallNumber ballNumber = new BallNumber(duplicateNumber);
            ballNumbers.add(ballNumber);
        }

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Ball(ballNumbers));
    }
}
