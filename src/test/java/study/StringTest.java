package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @DisplayName("문자열 분리 테스트")
  @Test
  void split_test() {
    String str = "1,2";
    assertThat(str.split(",")).containsExactly("1", "2");
  }

  @DisplayName("문자열 분리 테스트2")
  @Test
  void split_test2() {
    String str = "1";
    assertThat(str.split(",")).contains("1");
  }

  @DisplayName("문자열 부분 추출 테스트")
  @Test
  void substring_test() {
    String str = "(1,2)";
    assertThat(str.substring(1, str.length() - 1)).isEqualTo("1,2");
  }

  @DisplayName("특정 위치 문자열 가져오기")
  @Test
  void charAt_test() {
    String str = "abc";
    assertThat(str.charAt(0)).isEqualTo('a');
    assertThat(str.charAt(1)).isEqualTo('b');
    assertThat(str.charAt(2)).isEqualTo('c');
    assertThatThrownBy(() -> str.charAt(3))
        .isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessage("String index out of range: 3");
    assertThatThrownBy(() -> str.charAt(4))
        .isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessage("String index out of range: 4");
  }

}
