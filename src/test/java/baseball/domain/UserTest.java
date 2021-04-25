package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @Test
    @DisplayName("Input 문자열 삽입 테서트")
    void user_input_str_insert_test() {
        String input = "12a";

        assertThatThrownBy(() -> {
            User.inputStrToList(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자1~9만 입력하세요.");
    }

    @Test
    @DisplayName("Input Size 테스트")
    void user_input_size_test() {
        String input = "1233";

        assertThatThrownBy(() -> {
            User.inputStrToList(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자1~9인 3자리 수 를 입력하세요.");
    }

    @Test
    @DisplayName("Input 중복 테스트")
    void user_input_diff_test() {
        String input = "113";

        assertThatThrownBy(() -> {
            User.inputStrToList(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 수 를 입력하세요.");
    }

    @Test
    @DisplayName("Input Restart 테스트")
    void user_input_restart_test() {
        String input = "3";

        assertThatThrownBy(() -> {
            User.validateRestart(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2를 입력해주세여");
    }
}