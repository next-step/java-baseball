package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberUtilTest {

    @DisplayName("int 타입의 숫자를 List<Integer> 타입으로 변환 테스트")
    @ParameterizedTest
    @ValueSource(ints = {123, 5555, 234, 894, 21, 2})
    void numberToListFromTest(int number) {
        assertThat(BaseballNumberUtil.numberToListFrom(number))
                .hasSize(String.valueOf(number).length());
    }
}
