package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionUtilTest {

  @Test
  @DisplayName("문자열 컬렉션을 특정 구분자로 합쳐 문자열로 반환한다.")
  void joining() {
    // given
    List<String> list = Arrays.asList("2", "1", "3");

    // when
    String actual = CollectionUtil.joining(list, ",");

    // then
    assertThat(actual).isEqualTo("2,1,3");
  }
}