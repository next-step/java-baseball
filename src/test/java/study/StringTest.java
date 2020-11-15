package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.platform.commons.util.StringUtils;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * String
 */
public class StringTest {

    @Test
    @DisplayName(value = "\"1,2\"을 ',' 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    public void checkSplitTest() {
        String numbers = "1,2";
        /* 1,2라는 문자열을 ',' 구분자를 기준으로 나누는 경우를 수행 */
        String[] actual = numbers.split(",");
        /* 실제 수행된 값을 비교할 기대 값인 배열 */
        String[] expected = new String[] {"1", "2"};
        /* 배열로 값을 반환하는 경우 기대값이 포함되어 있는 지 확인시 contains */
        assertThat(actual).contains("1");
        /* 배열로 반환된 값의 각 원소를 정확하게 포함하고 있는지 비교 */
        assertThat(actual).containsExactly(expected);
    }

    @Test
    @DisplayName(value = "\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    public void checkReturnArrayTest() {
        /* 실제 수행 값 */
        String[] actual = "1".split(",");
        /* 기대 값 */
        String[] expected = new String[] {"1"};

        /* */
        assertThat(actual).contains("1");
        /* '1'을 ',' 구분자로 나누어 배열로 담는 경우 1만을 포함하는 배열이 반환되는지 학습 테스트 */
        assertThat(actual).containsExactly(expected);
    }

    @Test
    @DisplayName(value = "\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환 테스트")
    public void checkSubstringTest() {
        String actual = "(1,2)";
        /* 괄호 제거 */
        String subStringActual = actual.substring(1, actual.indexOf(")"));
        /* 비교할 기대 값 */
        String expected = "1,2";
        /* 기대값과 같은 */
        assertThat(subStringActual).isEqualTo(expected);
    }

    @Test
    @DisplayName(value = "String의 charAt() 메소드를 활용하여 특정 위치의 문자를 가져오는 테스트")
    public void checkCharAtTest() {
        /* 문자열이 주어지고 각 문자의 인덱스를 확인하는 테스트 */
        String actual = "abc";
        /* charAt을 통한 각 인덱스의 '문자' 를 확인*/
        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName(value = "charAt 활용 시 발생할 수 있는 StringIndexOutOfBoundsException ThrownBy 테스트")
    public void checkCharAtThrownByTest() {
        String actual = "ab";
        /* 제데로된 학습 케이스 필요 */
        assertThatThrownBy(() -> {
            try {
                /* charAt을 사용하여 벗어난 인덱스를 요청하여 StringIndexOutOfBoundsException 예외를 발생 */
                char ch = actual.charAt(3);
            } catch(StringIndexOutOfBoundsException e) {
                throw new StringIndexOutOfBoundsException("Index: " + actual.length() + ", Size: " + actual.length());
            }
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 2");
    }

    @Test
    @DisplayName(value = "charAt 활용 시 발생할 수 있는 StringIndexOutOfBoundsException ExceptionOfType 테스트")
    public void checkCharAtExceptionOfTypeTest() {
        String actual = "a";
        int expected = 2;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                        /* charAt을 사용하여 벗어난 인덱스를 요청하여 StringIndexOutOfBoundsException 예외를 발생 */
                        assertThat(actual.charAt(expected))
                                .as("String index out of range: \\d+", actual.length());
                }).withMessageContaining("String index out of range: ");
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of(" ", true),
                Arguments.of("not blank", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    @DisplayName("[학습] MethodSource resource를 호출하여 값에 대한 검증 작업이 가능")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        /* 기대값, 입력 값 */
        assertEquals(expected, StringUtils.isBlank(input));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("[학습] 메서드명이 동일한 경우 자동으로 MethodSource 어노테이션이 호출")
    public void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(String input) {
        assertTrue(StringUtils.isBlank(input));
    }

    private static Stream<String> isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument() {
        return Stream.of(null, "", " ");
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void isBlank_ShouldReturnTrueForNullAndEmptyStrings(String input) {
        assertTrue(StringUtils.isBlank(input));
    }
}
