import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class GameNumberTest {
    @Test
    @DisplayName("랜덤으로 생성된 숫자가 예외를 발생시키지 않는다.")
    void checkRandomGenerateTest() throws ContainsZeroException {
        GameNumber.randomGenerate();
    }

//    @Test
//    @DisplayName("랜덤으로 생성된 3자리 숫자의 크기가 세 자리다.")
//    void checkSizeTest() {
//        List<Integer> test = GameNumber.randomGenerate();
//        assertThat(GameNumber.randomGenerate().size()).isEqualTo(3);
//    }
//
//    @Test
//    @DisplayName("랜덤으로 생성된 3자리 숫자가 중복되지 않는다.")
//    void checkDuplicationTest() {
//        Set<Integer> gameNumberSet = new HashSet<>(GameNumber.randomGenerate());
//        assertThat(gameNumberSet.size()).isEqualTo(3);
//    }

    @Test
    @DisplayName("0이 포함되면 ContainsZeroException을 출력한다.")
    void ofContainsZeroTest() {
        //given
        Integer[] inputContainsZero = new Integer[]{0, 1, 2};

        assertThatThrownBy(() -> {
            // when
            GameNumber.of(Arrays.asList(inputContainsZero)); })
                // then
                .isInstanceOf(ContainsZeroException.class)
                .hasMessageContaining("숫자에 0을 포함해서는 안됩니다.");
    }

    @Test
    @DisplayName("서로 다른 수가 아닌 값을 입력하였을 때 예외를 출력한다.")
    void ofDuplicationTest() {
        //given
        Integer[] inputDuplication = new Integer[]{1, 1, 2};

        assertThatThrownBy(() -> {
            // when
            GameNumber.of(Arrays.asList(inputDuplication)); })
                // then
                .isInstanceOf(ContainsDuplicationException.class)
                .hasMessageContaining("숫자가 중복되어서는 안됩니다.");
    }

    @Test
    @DisplayName("세 자리 수가 아닌 값을 입력하였을 때 예외를 출력한다.")
    void ofSizeTest() {
        //given
        Integer[] inputTwoNumbers = new Integer[]{1, 2};
        assertThatThrownBy(() -> {
            // when
            GameNumber.of(Arrays.asList(inputTwoNumbers)); })
            // then
                .isInstanceOf(NotThreeDigitException.class)
                .hasMessageContaining("세 자리 수만 입력할 수 있습니다");
    }
}