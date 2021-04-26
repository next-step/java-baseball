package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TransStringNumberToNumberListUtilTest {

    @DisplayName("입력받은 숫자 문자열을 정수 리스트로 변환하는 테스트")
    @Test
    void transStringToNumberTest() {
        String numberString = "123";

        List<Integer> numbers = TransStringNumberToNumberListUtil.toNumberList(numberString);

        assertThat(numbers).hasSize(3);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @DisplayName("입력받은 숫자 문자열이 숫자가 아닌경우 예외 테스트")
    @Test
    void transStringToNumberExceptionTest() {
        String numberString = "가나다";

        assertThatThrownBy(() ->
                TransStringNumberToNumberListUtil.toNumberList(numberString)
        ).isInstanceOf(IllegalArgumentException.class);

    }
}
