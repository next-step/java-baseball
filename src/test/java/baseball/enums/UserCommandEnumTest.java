package baseball.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserCommandEnumTest {

    @Test
    @DisplayName("contains 메소드 작동 테스트")
    void contain_test() {
        Assertions.assertThat(UserCommandEnum.contains("1")).isTrue();
        Assertions.assertThat(UserCommandEnum.contains("2")).isTrue();
        Assertions.assertThat(UserCommandEnum.contains("3")).isFalse();
    }
}