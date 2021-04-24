package study;

import org.junit.jupiter.api.Assertions;
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

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        // HashSet은 저장하기 전 hashCode()메소드를 호출해서 해시코드를 비교후 중복된 객체라면 저장하지 않는다.
        // 확인할 수 있는 테스트 코드는 size()메소드를 확인하면 알 수 있다.
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항 1\nSet의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트")
    void size() {
        int size = numbers.size();

        Assertions.assertEquals(size, 3);
    }

    @ParameterizedTest
    @DisplayName("요구사항 2\nSet의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("요구사항 3\n요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. " +
            "false 가 반환되는 테스트도 추가하여 하나의 Test Case로 구현")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(int value, boolean expected) {
        Assertions.assertEquals(numbers.contains(value), expected);
    }
}
