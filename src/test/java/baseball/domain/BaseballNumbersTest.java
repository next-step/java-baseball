package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BaseballNumbersTest {

    @Test
    @DisplayName("null 파라미터 입력")
    void create_inputNull() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbers(null))
                .withMessageMatching("숫자 정보를 입력해 주세요.");
    }

    @Test
    @DisplayName("빈 사이즈 리스트")
    void create_inputEmpty() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BaseballNumbers(new ArrayList<>()))
                .withMessageMatching("숫자는 3 개로 이루어져야 합니다.");
    }

}