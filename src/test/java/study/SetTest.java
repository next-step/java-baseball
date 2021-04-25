package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("numbers 변수 사이즈 테스트")
    @Test
    public void sizeTest() {

        // when
        int setSize = numbers.size();

        // then
        Assertions.assertThat(setSize).isEqualTo(3);
    }

    @DisplayName("JUnit의 ParameterizedTest 어노테이션 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void parameterizedTest(int given) {

        // when
        boolean result = numbers.contains(given);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("JUnit의 CsvSource 어노테이션 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiterString = ":")
    public void csvSourceTest(String given, String expected) {

        // when
        boolean result = numbers.contains(Integer.parseInt(given));

        // then
        Assertions.assertThat(result).isEqualTo(Boolean.parseBoolean(expected));
    }
}
