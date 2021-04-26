package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballGameModelTest {

    BaseballGameModel sut;

    @Test
    void 사용자로부터_값을_입력받는다() {
        String userInput = "123";
        sut = new BaseballGameModel(userInput);
        String value = sut.userInput();
        assertThat(value).isEqualTo(userInput);
    }

    @Test
    void 사용자로부터_입력받은_값은_3자리_숫자여야한다() {
        String _123 = "123";
        sut = new BaseballGameModel(_123);
        String value = sut.userInput();
        char[] chars = value.toCharArray();
        assertThat(chars.length).isEqualTo(3);
        for (char c : chars) {
            assertThat(Character.isDigit(c)).isTrue();
        }
    }

    @ParameterizedTest(name = "[{index}] 사용자값 {argumentsWithNames}이 3자리 숫자가 아닐 경우 IllegalArgumentException 발생한다 ")
    @ValueSource(strings = {"1", "12", "1234"})
    void 사용자_값이_3자리_숫자가_아닐경우_IllegalArgumentException_을_던진다(String input) {
        sut = new BaseballGameModel(input);
        assertThatThrownBy(() -> sut.userInput()).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("3자리 숫자만 허용합니다.");
    }

    @ParameterizedTest(name = "[{index}] 사용자값 {argumentsWithNames}가 숫자가 아닐 경우 IllegalArgumentException 발생한다 ")
    @ValueSource(strings = {"a", "abc", "abc123", "1qa"})
    void 사용자_값이_숫자가_아닐경우_IllegalArgumentException_을_던진다(String input) {
        sut = new BaseballGameModel(input);
        assertThatThrownBy(() -> sut.userInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("3자리 숫자만 허용합니다.");
    }

}