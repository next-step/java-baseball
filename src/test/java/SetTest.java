import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 사이즈 확인 테스트")
    public void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }


    @DisplayName("ParameterizedTest 중복코드를 제거하여 Set 숫자 일치 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void numberContainsTest(int inputNum) {
        assertThat(numbers.contains(inputNum)).isTrue();

    }

    @DisplayName("contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과값이 다른 경우에 대한 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 : true", "2 : true", "3 : true", "4 : false", "5 : false"}, delimiter = ':')
    public void numberContainsTrueFalseTest(int inputNum, boolean expected) {
        assertThat(numbers.contains(inputNum)).isEqualTo(expected);
    }


}
