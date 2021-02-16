package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumbersTest {

    @DisplayName("null로 생성 시 exception 발생")
    @Test
    void nullParameterThrowsException() {
        assertThrows(NullPointerException.class,
                () -> new Numbers(null));
    }

    @DisplayName("3자리가 아닌 수로 생성 시 exception 발생")
    @Test
    void numbersSizeMustBeThree() {
        // given
        List<Integer> numbersList = List.of(1, 2, 3, 4);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Numbers(numbersList));
        assertThat(exception.getMessage()).isEqualTo("숫자는 3자리로 구성되어야 합니다.");
    }

    @DisplayName("numbers의 자릿수를 리턴")
    @Test
    void digits() {
        // given
        List<Integer> numbersList = List.of(3, 6, 9);
        Numbers numbers = new Numbers(numbersList);

        // when
        int size = numbers.numberOfDigits();

        // then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("toString() 호출 시 문자열 형태로 리턴")
    @Test
    void toStringTest() {
        // given
        List<Integer> numbersList = List.of(3, 6, 9);
        Numbers numbers = new Numbers(numbersList);

        // when
        String toString = numbers.toString();

        // then
        assertThat(toString).isEqualTo("369");
    }
}