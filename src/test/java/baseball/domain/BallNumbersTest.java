package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallNumbersTest {

    @DisplayName("결과값은 3자리 숫자인지 테스트 - 볼 각각의 값 합쳐서 3자리")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "956", "136"})
    void createNumbers(String input) {
        BallNumbers ballNumbers = new BallNumbers(input);

        assertThat(ballNumbers).isEqualTo(new BallNumbers(input));
    }

    @DisplayName("결과값은 [중복되지 않은] 3자리 숫자가 아닐 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "13", "3", "133", "911", "222"})
    void validateNumbers1(String input) {
        assertThatThrownBy(() -> {
            new BallNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 중복되지 않은 3자리 숫자여야 합니다.");
    }

    @DisplayName("BallNumbers 값에 빈 값 혹은 빈문자열 입력시 예외 발생 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNumbers2(String input) {
        assertThatThrownBy(() -> {
            new BallNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 값은 넣을 수 없습니다.");
    }

    @DisplayName("결과값은 [중복되지 않은] 3자리 숫자가 아닐 경우 예외 발생 테스트 - 리스트 파라미터 생성자 생성시")
    @Test
    void validateNumbers3() {
        List<BallNumber> ballNumbers = Arrays.asList(
                new BallNumber("1"), new BallNumber("1"), new BallNumber("3")
        );
        assertThatThrownBy(() -> {
            new BallNumbers(ballNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 중복되지 않은 3자리 숫자여야 합니다.");
    }

    @DisplayName("BallNumbers 객체에 저장된 값 중 외부에서 입력한 값이 존재하는지 테스트 - 1개라도 일치하는 값이 있는지")
    @Test
    void hasContains() {
        BallNumbers saved = new BallNumbers("123");

        assertThat(saved.hasContains(new BallNumbers("157"))).isTrue();
    }

    @DisplayName("BallNumbers 객체에 저장된 값 중 외부에서 입력한 값이 존재하는지 테스트 - 1개라도 일치하는 값이 없을때")
    @Test
    void hasNotContains() {
        BallNumbers saved = new BallNumbers("123");

        assertThat(saved.hasContains(new BallNumbers("456"))).isFalse();
    }

    @DisplayName("BallNumbers 객체에 저장된 값 중 외부에서 정확히 입력한 값(인덱스로 지정한 값) 존재하는지 테스트")
    @Test
    void contains() {
        BallNumbers saved = new BallNumbers("123");

        assertThat(saved.contains(new BallNumbers("245"), 0)).isTrue();
    }

    @DisplayName("BallNumbers 객체에 저장된 값 중 외부에서 정확히 입력한 값(인덱스로 지정한 값) 존재하지 않는 경우 테스트")
    @Test
    void notContains() {
        BallNumbers saved = new BallNumbers("123");

        assertThat(saved.contains(new BallNumbers("245"), 1)).isFalse();
    }
}
