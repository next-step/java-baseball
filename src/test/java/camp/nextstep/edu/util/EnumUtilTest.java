package camp.nextstep.edu.util;

import camp.nextstep.edu.code.GameOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EnumUtilTest {

    @Test
    @DisplayName("GameOption 값 검사 - 성공 테스트")
    void gameOption_isEqual_successTest() {
        // given & when
        boolean result1 = EnumUtil.isEqual("1", GameOption.RESTART);
        boolean result2 = EnumUtil.isEqual("2", GameOption.EXIT);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
    }
}
