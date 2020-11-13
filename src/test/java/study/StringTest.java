package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Junit, AssertJ 사용법 숙지")
public class StringTest {
    private static final String SEPARATOR = ",";

    private static final String ONE = "1";
    private static final String TWO = "2";

    private static final String ONE_AND_TWO = "1,2";

    @ParameterizedTest
    @ValueSource(strings = "1,2")
    @DisplayName("[요구사항 1] '1,2' 문자열을 ','으로 split 할 때 '1', '2'로 잘 분리되는지 확인")
    void validateContainElementsInReturnStringArrayWhenSplitParam(final String givenInput) {
        final String[] splitStrArr = givenInput.split(SEPARATOR);

        // 이 방법은 해당 테스트에 적합하지 않음
//        assertThat(splits[0]).isEqualTo(one);
//        assertThat(splits[1]).isEqualTo(two);

        assertThat(splitStrArr).contains(ONE, TWO);
    }

    @ParameterizedTest
    @ValueSource(strings = "1")
    @DisplayName("[요구사항 1] '1' 문자열을 ','으로 split 할 때 '1'만을 포함하는 배열을 반환하는지 확인")
    void validateContainOnlyOneInReturnStringArrayWhenSplitParam(final String givenInput) {
        final String[] splitStrArr = givenInput.split(SEPARATOR);

        assertThat(splitStrArr).containsExactly(ONE);
    }

    @ParameterizedTest
    @ValueSource(strings = "(1,2)")
    @DisplayName("[요구사항 2] '(1,2)' 문자열을 substring 메서드를 사용하여 '('와 ')'을 제거하여 '1,2'만을 포함하는 배열을 반환하는지 확인")
    void validateEqualsReturnStringOneAndTwoWhenSubstringParam(final String givenInput) {
        final String oneAndTwo = givenInput.substring(1, givenInput.length() - 1);

        assertThat(oneAndTwo).isEqualTo(ONE_AND_TWO);
    }

    @ParameterizedTest
    @ValueSource(strings = "abc")
    @DisplayName("[요구사항 3-1] 'abc' 문자열을 charAt 메서드를 사용하여 유요한 위치값을 벗어나면 StringIndexOutOfBoundsException 예외가 발생하는지 확인")
    void validateStringIndexOutOfBoundsExceptionWhenCharAtParam1(final String givenInput) {
        assertThatThrownBy(
            () -> givenInput.charAt(givenInput.length()))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: 3");
    }

    @ParameterizedTest
    @ValueSource(strings = "abc")
    @DisplayName("[요구사항 3-2] 'abc' 문자열을 charAt 메서드를 사용하여 유요한 위치값을 벗어나면 StringIndexOutOfBoundsException 예외가 발생하는지 확인")
    void validateStringIndexOutOfBoundsExceptionWhenCharAtParam2(final String givenInput) {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> givenInput.charAt(givenInput.length()))
            .withMessageMatching("String index out of range: 3");
    }
}
