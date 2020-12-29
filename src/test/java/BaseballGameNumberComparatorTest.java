import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameNumberComparatorTest {

    BaseballGameNumberComparator comparator = new BaseballGameNumberComparator(3);

    @Test
    @DisplayName("볼 갯수 테스트")
    void getBall() {
        Assertions.assertThat(comparator.getBall(123, 231)).isEqualTo(3);
        Assertions.assertThat(comparator.getBall(123, 321)).isEqualTo(2);
        Assertions.assertThat(comparator.getBall(123, 345)).isEqualTo(1);
        Assertions.assertThat(comparator.getBall(123, 456)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 존재여부 체크 테스트")
    void checkFirstDigit() {
        boolean[] check = new boolean[10];
        Assertions.assertThat(comparator.checkDigit(check, 123, 0)).isEqualTo(1);
        Assertions.assertThat(comparator.checkDigit(check, 123, 1)).isEqualTo(1);
        Assertions.assertThat(comparator.checkDigit(check, 123, 2)).isEqualTo(1);
        Assertions.assertThat(comparator.checkDigit(check, 321, 0)).isEqualTo(0);
        Assertions.assertThat(comparator.checkDigit(check, 321, 1)).isEqualTo(0);
        Assertions.assertThat(comparator.checkDigit(check, 321, 2)).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크 갯수 테스트")
    void getStrike() {
        Assertions.assertThat(comparator.getStrike(123, 456)).isEqualTo(0);
        Assertions.assertThat(comparator.getStrike(123, 321)).isEqualTo(1);
        Assertions.assertThat(comparator.getStrike(123, 423)).isEqualTo(2);
        Assertions.assertThat(comparator.getStrike(123, 123)).isEqualTo(3);
    }

    @Test
    @DisplayName("첫번째 자릿수 비교 테스트")
    void compareFirstDigit() {
        Assertions.assertThat(comparator.compareFirstDigit(123, 543)).isEqualTo(1);
        Assertions.assertThat(comparator.compareFirstDigit(132, 514)).isEqualTo(0);
        Assertions.assertThat(comparator.compareFirstDigit(126, 564)).isEqualTo(0);
        Assertions.assertThat(comparator.compareFirstDigit(528, 358)).isEqualTo(1);
    }
}