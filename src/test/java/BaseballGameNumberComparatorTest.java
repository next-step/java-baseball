import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameNumberComparatorTest {

    @Test
    @DisplayName("볼 갯수 테스트")
    void getBall() {
        BaseballGameNumberComparator baseballGameNumberComparator = new BaseballGameNumberComparator(3);
        Assertions.assertThat(baseballGameNumberComparator.getBall(123, 321)).isEqualTo(2);
    }

    @Test
    void checkFirstDigit() {
    }

    @Test
    void getStrike() {
    }

    @Test
    void compareFirstDigit() {
    }
}