package study;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringTest {

  @Test
  @DisplayName("1,2 split")
  void testWordSplit_1() throws Exception {
    // given
    final String words = "1,2";

    // when
    final String[] split = words.split(",");

    // then
    assertThat(split).contains("1", "2");
  }

  @Test
  @DisplayName("1 split")
  void testWordSplit_2() throws Exception {
    // given
    final String words = "1";

    // when
    final String[] split = words.split(",");

    // then
    assertThat(split).containsExactly("1");
  }

  @Test
  @DisplayName("(1, 2) substring")
  void testSubstring() throws Exception {
    // given
    String words = "(1,2)";

    // when
    int index = words.indexOf("(");
    int lastIndex = words.lastIndexOf(")");
    words = words.substring(index + 1, lastIndex);

    // then
    assertThat(words).isEqualTo("1,2");
  }

  @Test
  @DisplayName("charAt 메서드 활용")
  void testCharAt() throws Exception {
    // given
    final String words = "abc";

    // when
    char peek = words.charAt(1);

    // then
    assertThat(peek).isEqualTo('b');
  }

  @Test
  @DisplayName("StringIndexOutOfBoundsException 테스트")
  void testExceptionThrown() throws Exception {
    // given
    final String words = "abc";

        /*assertThatThrownBy(() -> {
            char peek = words.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");*/

    assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
      char peek = words.charAt(4);
    }).withMessageMatching("String index out of range: \\d+");
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " "})
  void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
    assertTrue(StringUtils.isBlank(input));
  }
}
