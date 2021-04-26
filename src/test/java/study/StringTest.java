package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

  @DisplayName(",기준 정상적으로 분리확인")
  @Test
  public void should_split_string_return_multiArray_string() {
    assertThat("1,2".split(",")).isNotEmpty()
        .containsExactly("1", "2");
  }

  @DisplayName(",기준 정상적으로 분리확인")
  @Test
  public void should_split_string_return_singleArray_string() {
    assertThat("1,".split(",")).containsExactly("1");
  }

  @DisplayName("1~4까지 string정상적으로 substring했는지 확인")
  @Test
  public void should_subString_string_return_removeBracket_string() {
    assertThat("(1,2)".substring(1, 4)).contains("1,2");
  }

  @DisplayName("String에서 charAt을 이용해 인덱스 반환 확인")
  @Test
  public void usingCharAt_should_get_SpecificChar() {
    assertThat("abc".charAt(0)).isEqualTo('a');
  }

  @DisplayName("String에서 charAt을 이용할 때 아웃된 인덱스 반환시 Exception 확인")
  @Test
  public void usingCharAt_outofrange_should_occur_StringIndexOutOfBoundsException() {
    assertThatThrownBy(() -> {
      "abc".charAt(3);
    }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 3");
  }
}