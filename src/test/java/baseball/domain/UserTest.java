package baseball.domain;

import baseball.view.UserInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    @DisplayName("Input 문자열 삽입 테서트")
    void userInput_str_insert_test() {
        String input = "12a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            UserInputView.inputNumbers();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자1~9만 입력하세요.");
    }

    @Test
    @DisplayName("Input Size 테스트")
    void userInput_size_test() {
        String input = "1233";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            UserInputView.inputNumbers();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자1~9인 3자리 수 를 입력하세요.");
    }

    @Test
    @DisplayName("Input 중복 테스트")
    void userInput_diff_test() {
        String input = "113";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            UserInputView.inputNumbers();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 수 를 입력하세요.");
    }
}