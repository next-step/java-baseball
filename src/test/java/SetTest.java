import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class SetTest {
    private Set<Integer> numbers;

    public Set<Integer> getNumbers() {
        return numbers;
    }

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항1 set의 크기 확인")
    void checkSetSize(){
        SetTest setTest = new SetTest();
        setTest.setUp();
        Set<Integer> numbers = setTest.getNumbers();
        System.out.println(numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2 중복 제거한 1,2,3 존재 확인 테스트")
    void containsNumber(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }


    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"} ,delimiter = ':')
    @DisplayName("요구사항3 결과값 true, false로 존재 확인 테스트")
    void checkContainsNumber(int input, Boolean bool) {
        System.out.println(input);System.out.println(bool);

        assertThat(numbers.contains(input)).isEqualTo(bool);

    }

}
