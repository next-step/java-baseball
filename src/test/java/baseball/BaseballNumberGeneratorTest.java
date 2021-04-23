package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberGeneratorTest {
    @Test
    @DisplayName("사이즈 3인 리스트 체크")
    public void checkListSizeTest() {
        BaseballNumberGenerator numberGenerator = new BaseballNumberGenerator();
        List<Integer> numberList = numberGenerator.generate();
        assertThat(numberList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("1~9 사이의 수 검증")
    public void validateNumberTest() {
        BaseballNumberGenerator numberGenerator = new BaseballNumberGenerator();
        List<Integer> numberList = numberGenerator.generate();
        for(int number : numberList) {
            assertThat(number).isBetween(1,9);
        }
    }

    @Test
    @DisplayName("서로 다른 수 검증")
    public void validateUniqueNumberTest() {
        BaseballNumberGenerator numberGenerator = new BaseballNumberGenerator();
        List<Integer> numberList = numberGenerator.generate();
        assertThat(numberList.get(0)).isNotEqualTo(numberList.get(1));
        assertThat(numberList.get(1)).isNotEqualTo(numberList.get(2));
        assertThat(numberList.get(2)).isNotEqualTo(numberList.get(0));
    }
}
