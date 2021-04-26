package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class JunitTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set Collection 사이즈 확인")
    public void checkSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }


    @ParameterizedTest
    @DisplayName("ParameterizedTest 활용하여 중복코드를 제거하고 Set 데이터 확인")
    @ValueSource(ints = {1, 2, 3})
    public void contains(int inputNum) {
        assertThat(numbers.contains(inputNum)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("입력 값에 따라서 결과가 달라지는 경우 테스트")
    @CsvSource(value = {"1 : true", "2 : true", "3 : true", "4 : false", "5 : false"}, delimiter = ':')
    public void isNumberContains(int inputNumber, boolean expected) {
        assertThat(numbers.contains(inputNumber)).isEqualTo(expected);
    }

}
