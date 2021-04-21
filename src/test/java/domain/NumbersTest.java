package domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @DisplayName("3자리 int를 넘기면 각 숫자를 담은 list 반환")
    @ValueSource(ints = { 123, 456, 789 })
    @ParameterizedTest
    void test01(int arg) {
        Numbers numbers = new Numbers(arg);
        List<Integer> list = numbers.get();

        int expected = 3;
        int actual = list.size();
        assertEquals(expected, actual);

        assertEquals(arg / 100, list.get(0));
        assertEquals((arg % 100) / 10, list.get(1));
        assertEquals(arg % 10, list.get(2));
    }

    @DisplayName("매개변수가 3자리 정수가 아니면 exception")
    @ValueSource(ints = { 0, 56, 1234 })
    @ParameterizedTest
    void test02(int arg) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(arg));
    }

    @DisplayName("list로 Numbers를 생성하는 경우 3자리 정수가 담겨있어야 함")
    @Test
    void test03() {

        List<Integer> success = Arrays.asList(1, 2, 3);
        assertDoesNotThrow(() -> new Numbers(success));

        List<Integer> fail = Arrays.asList(1, 2);
        assertThatIllegalArgumentException().isThrownBy(() -> new Numbers(fail));
    }
}