package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Junit, AssertJ 사용법 숙지")
public class StringTest {
    private static final String SEPARATOR = ",";

    private static final String ONE = "1";
    private static final String TWO = "2";

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
}
