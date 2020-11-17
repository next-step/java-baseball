package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitAssertJTest {

    @Test
    @DisplayName("1, 2 을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트 구현")
    void 구분테스트() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void 한개구분테스트() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String 의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현한다.")
    void 괄호제거테스트() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt으로 특정값을 가져오고 벗어나면 예외를 발생")
    void 차타입가져오기() {
        String result = "abc";
        assertThat(result.charAt(1)).isEqualTo('b');

        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    assertThat(result.charAt(3)).isEqualTo('b');
                });
    }

    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    void 셋사이즈테스트(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("contains 와 ParameterizedTest 테스")
    @ValueSource(ints = { 1, 2, 3 })
    void 셋포함숫자와중복테스트(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = { "1,true", "2,true", "3,true", "4,false", "5,false" })
    void 씨에스브이테스트(int number, boolean expected) {
        assertEquals(expected, numbers.contains(number));
    }
}