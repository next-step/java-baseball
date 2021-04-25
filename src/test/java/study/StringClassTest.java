package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringClassTest {

    @Test
    public void string_split_test() {
        String test1 = "1,2";
        String test2 = "1";

        String[] split1 = test1.split(",");
        String[] split2 = test2.split(",");

        Assertions.assertThat(split1).isNotNull()
                                     .contains("1", "2");

        Assertions.assertThat(split2).isNotNull()
                                     .containsExactly("1");
    }

    @Test
    public void string_substring_test() {
        String test = "(1,2)";

        test = test.substring(test.indexOf("(") + 1, test.indexOf(")"));
        Assertions.assertThat(test).isEqualTo("1,2");
    }

    @Test
    public void string_charat_test_success_case() {
        String test ="123";
        char selectedChar = test.charAt(1);

        Assertions.assertThat(selectedChar)
                  .isEqualTo('2');
    }

    @Test
    @DisplayName("문자열 추출 시도 시 예외발생 테스트")
    public void string_charat_test_fail_case() {
        String test ="123";

        Assertions.assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                  .isThrownBy(() -> {
                      test.charAt(4);
                  }).withMessageMatching("String index out of range: \\d+");
    }
}
