import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Numbers 테스트")
public class NumbersTest {

    @DisplayName("숫자가 아닌 값을 입력하면 예외 발생")
    @Test
    void nonNumericStringThrowsException() {
        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Numbers numbers = new Numbers("string");
        });
        assertThat(exception.getMessage()).isEqualTo("숫자가 아닙니다.");
    }

    @DisplayName("빈 문자열을 입력하면 예외 발생")
    @Test
    void emptyStringThrowsException() {
        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Numbers numbers = new Numbers(" ");
        });
        assertThat(exception.getMessage()).isEqualTo("숫자가 아닙니다.");
    }

    @DisplayName("3자리 수가 아니면 예외 발생")
    @Test
    void nonThreeDigitsNumberThrowsException() {
        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Numbers numbers = new Numbers("9723");
        });
        assertThat(exception.getMessage()).isEqualTo("3자리의 정수여야만 합니다.");
    }

    @DisplayName("숫자 중 0이 포함되면 예외 발생")
    @Test
    void zeroIncludedNumberThrowsException() {
        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Numbers numbers = new Numbers("906");
        });
        assertThat(exception.getMessage()).isEqualTo("0이 포함된 수는 사용할 수 없습니다.");
    }

    @DisplayName("각 자리 중 중복된 수가 있으면 예외 발생")
    @Test
    void duplicatedNumberThrowsException() {
        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Numbers numbers = new Numbers("373");
        });
        assertThat(exception.getMessage()).isEqualTo("각 자리의 수는 모두 달라야 합니다.");
    }

    @DisplayName("생성자에 비어 있는 리스트를 넣으면 예외 발생")
    @Test
    void emptyListParameterThrowsException() {
        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Numbers numbers = new Numbers(List.of());
        });
        assertThat(exception.getMessage()).isEqualTo("내용이 충분하지 않습니다.");
    }
}
