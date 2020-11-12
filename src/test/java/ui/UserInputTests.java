package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.exceptions.InvalidSizeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTests {
    @DisplayName("문자열로 사용자의 입력을 받아 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        UserInput userInput = new UserInput("123");

        assertThat(userInput).isNotNull();
    }

    @DisplayName("사용자가 입력한 문자열의 크기가 3이 아닌 경우 예외가 발생한다.")
    @Test
    void createFailTest() {
        assertThatThrownBy(() -> new UserInput("1234")).isInstanceOf(InvalidSizeException.class);
    }
}
