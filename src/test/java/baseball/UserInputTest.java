package baseball;

import baseball.numbergenerator.NumberGenerator;
import baseball.numbergenerator.ThreeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {

    private static final String USER_INPUT = "123";
    UserInput sut;

    @BeforeEach
    void setUp() {
        sut = UserInput.of(USER_INPUT);
    }

    @Test
    void 사용자로부터_값을_입력받는다() {
        assertThat(sut).isEqualTo(UserInput.of(USER_INPUT));
    }

    @Test
    void 사용자로부터_입력받은_값은_3자리_숫자여야한다() {
        List<Character> chars = sut.getValue();
        for (char c : chars) {
            assertThat(Character.isDigit(c)).isTrue();
        }
    }

    @Test
    void 사용자로부터_입력받는_값은_반복_된_값_일경우_IllegalArgumentException을_던진다() {
        assertThatThrownBy(() -> sut = UserInput.of("111"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("중복 숫자를 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "[{index}] 사용자값 {argumentsWithNames}이 3자리 숫자가 아닐 경우 IllegalArgumentException 발생한다 ")
    @ValueSource(strings = {"1", "12", "1234"})
    void 사용자_값이_3자리_숫자가_아닐경우_IllegalArgumentException_을_던진다(String input) {
        assertThatThrownBy(() -> sut = UserInput.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("3자리 숫자만 허용합니다.");
    }

    @ParameterizedTest(name = "[{index}] 사용자값 {argumentsWithNames}가 숫자가 아닐 경우 IllegalArgumentException 발생한다 ")
    @ValueSource(strings = {"a", "abc", "abc123", "1qa"})
    void 사용자_값이_숫자가_아닐경우_IllegalArgumentException_을_던진다(String input) {
        assertThatThrownBy(() -> sut = UserInput.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("3자리 숫자만 허용합니다.");
    }


}