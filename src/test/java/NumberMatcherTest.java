import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberMatcherTest {

    private NumberMatcher numberMatcher = new NumberMatcher();

    @DisplayName("결과 반환 테스트")
    @ParameterizedTest
    @CsvSource({"123, 321, 123", "236, 257, 101", "573, 754, 022", "743, 265, 000", "765, 567, 123"})
    void 결과_반환_테스트(String inputNumber, String answerNumber, String expectedResult) {
        //when
        String result = numberMatcher.matchNumber(inputNumber, answerNumber);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

}
