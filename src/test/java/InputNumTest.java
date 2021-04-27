import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class InputNumTest {
    @Test
    @DisplayName("입력받은 수가 3자리가 아닐경우 false값을 반환하는지 확인한다")
    void checkNumSizeErrorTest() {
        String testNum = "1433";
        Boolean checkResult = InputNum.checkNumSize(testNum);
        assertThat(checkResult).isFalse();
    }

    @Test
    @DisplayName("입력받은 수가 3자리가 맞을경우 true값을 반환하는지 확인한다")
    void checkNumSizeTest() {
        String testNum = "143";
        Boolean checkResult = InputNum.checkNumSize(testNum);
        assertThat(checkResult).isTrue();
    }

    @Test
    @DisplayName("1과 9 사이에 해당하지 않는 숫자가 포함되어 있을때 false값을 반환하는지 확인한다")
    void checkOneToNineTest() {
        String testNum = "012";
        Boolean checkResult = InputNum.checkOneToNine(testNum);
        assertThat(checkResult).isFalse();
    }

    @Test
    @DisplayName("두개이상의 중복된 숫자를 가지고 있는경우, true값을 반환하는지 확인한다")
    void checkDuplicateNumTest() {
        String testNum = "110";
        Boolean checkResult = InputNum.checkDuplicateNum(testNum);
        assertThat(checkResult).isTrue();
    }

    @Test
    @DisplayName("중복된 숫자를 가지고 있지 않은경우, false값을 반환하는지 확인한다")
    void checkDuplicateNumErrorTest() {
        String testNum = "234";
        Boolean checkResult = InputNum.checkDuplicateNum(testNum);
        assertThat(checkResult).isFalse();
    }

}
