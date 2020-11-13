package me.totoku103.baseball.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class SimpleStringUtilsTest {

    @Test
    @DisplayName("요구사항1-1: 문자열 중 ,로 분리가 잘되는지 확인")
    public void requirements1_1() {
        final String testString = "1,2";
        final String[] resultStrings = SimpleStringUtils.splitWithCommas(testString);


        assertThat(resultStrings)
                .isNotNull();

        assertThat(resultStrings.length)
                .isEqualTo(2);

        assertThat(resultStrings)
                .containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항1-2: 문자열 중 , 가 없는 경우")
    public void requirements1_2() {
        final String testString = "12";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> SimpleStringUtils.splitWithCommas(testString));
    }

    @Test
    @DisplayName("요구사항1-3: 문자열이 , 로 끝나는 경우")
    public void requirements1_3() {
        final String testString = "12,";
        final String[] resultStrings = SimpleStringUtils.splitWithCommas(testString);

        assertThat(resultStrings)
                .isNotNull();

        assertThat(resultStrings.length)
                .isEqualTo(1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("요구사항1-4: 빈문자열 or Null")
    public void requirements1_4(String args) {
        assertThatNullPointerException()
                .isThrownBy(() -> SimpleStringUtils.splitWithCommas(args));
    }

    /**
     * String의 Substring() 메소드를 활용.
     */
    @Test
    @DisplayName("요구사항2-1: 문자열 중 ,로 문자열 분리 후 숫자만 취득")
    public void requirements2_1() {
        final String testString = "(1,2)";

        final String resultStrings = SimpleStringUtils.removeStartAndLastParentheses(testString);

        assertThat(resultStrings)
                .isNotNull();

        assertThat(resultStrings)
                .isEqualTo("1,2");

        assertThat(resultStrings)
                .doesNotContain("(", ")");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2)", "(1,2", "1,2"})
    @DisplayName("요구사항2-2: 괄호 부족 및 없는 경우")
    public void requirements2_2(String args) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> SimpleStringUtils.removeStartAndLastParentheses(args));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    @DisplayName("요구사항3-1: charAt 정상 범위")
    public void requirements3_1(String strings) {

        assertThat(strings)
                .isNotNull();

        assertThat(strings.charAt(0))
                .isEqualTo('a');

        assertThat(strings.charAt(1))
                .isEqualTo('b');

        assertThat(strings.charAt(2))
                .isEqualTo('c');


    }

    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    @DisplayName("요구사항3-2: charAt Index 접근 범위 초과")
    public void requirements3_2(String strings) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> strings.charAt(strings.length() + 1));
    }
}
