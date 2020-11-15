package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Set 컬렉션의 값 확인 테스트 클래스
 */
public class SetTest {
    private Set<Integer> numbers;
    private Set<String> strings;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1); /* set에 중복된 값을 넣어 확인 */
        numbers.add(2);
        numbers.add(3);

        strings = new HashSet<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
    }

    @Test
    @DisplayName("[Set] size() 를 활용하여 Set의 크기를 확인하는 테스트")
    public void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[Set] contains() 메서드를 통해 값의 여부를 확인하는 테스트")
    public void containsTest() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings= {"", " "})
    @DisplayName("[Sample] 중복 코드를 제거 하기 위한 ParameterizedTest 학습 테스트")
    public void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("[Set] ParameterizedTest를 통한 Set에 담긴 숫자 테스트")
    public void checkSetValue(Integer digit) {
        assertTrue(numbers.contains(digit));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    @DisplayName("[Set] ParameterizedTest를 활용한 값 검색 Fail 테스트")
    public void checkFailSetValue(Integer digit) {
        assertFalse(numbers.contains(digit));
    }

    @ParameterizedTest
    @CsvSource(value = {"test:test", "Java:java"}, delimiter = ':')
    @DisplayName("[학습] CsvSource 테스트")
    public void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
        /* 입력 값에 대해 lowercase처리 후 기대값과 비교 */
        String actualValue = input.toLowerCase();
        /* 기대값, 입력값 */
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    @DisplayName("[Set] doesNotContain() 포함되지 않은 숫자 확인")
    public void checkSetDoesNotContainTest(Integer digit) {
        assertThat(numbers).doesNotContain(digit);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b"})
    @DisplayName("[Set] doesNotContain() 포함되지 않은 숫자 확인")
    public void checkStringSetList(String input) {
        assertThat(strings)
                .isNotEmpty()
                .contains(input)
                .doesNotContainNull()
                .containsSequence("c");
    }
}
