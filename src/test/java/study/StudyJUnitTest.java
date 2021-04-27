package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StudyJUnitTest {

    @Test
    public void splitTest() {
        String test1 = "1,2";
        String test2 = "1";
        String[] splitString1 = test1.split(",");
        String[] splitString2 = test2.split(",");
        assertThat(splitString1).contains("1","2");
        assertThat(splitString2).containsExactly("1");
    }

    @Test
    public void substringTest() {
        String test1 = "(1,2)";
        String result = test1.substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드 테스트 및 IndexOutOfBoundsException 테스트")
    public void charAtTest() {
        String test1 = "abc";
        assertThat(test1.charAt(0)).isEqualTo('a');
        assertThat(test1.charAt(1)).isEqualTo('b');
        assertThat(test1.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            test1.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");

    }
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
    @DisplayName("set size 크기 확인")
    public void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("contains 메소드를 활용해 숫자 값이 존재하는지 확인 테스트")
    public void containsNumberTest() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void containsNumberTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
    public void containsNumberTest2(int input, boolean expect) {
        assertThat(numbers.contains(input)).isEqualTo(expect);
    }

}
