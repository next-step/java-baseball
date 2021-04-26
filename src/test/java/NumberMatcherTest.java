import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberMatcherTest {

    @DisplayName("결과 반환 테스트")
    @ParameterizedTest
    @CsvSource({"123, 321, 123", "236, 257, 101", "573, 754, 022", "743, 265, 000", "765, 567, 123"})
    void 결과_반환_테스트(String inputNumber, String generatedNumber, String expectedResult) {
        //given
        NumberMatcher numberMatcher = new NumberMatcher(inputNumber, generatedNumber);
        String[] resultArr = expectedResult.split("");
        //when
        numberMatcher.matchNumber();
        int strike = numberMatcher.getStrike();
        int ball = numberMatcher.getBall();
        int total = numberMatcher.getTotalMatch();
        //then
        assertThat(String.valueOf(strike)).isEqualTo(resultArr[0]);
        assertThat(String.valueOf(ball)).isEqualTo(resultArr[1]);
        assertThat(String.valueOf(total)).isEqualTo(resultArr[2]);
    }

}
