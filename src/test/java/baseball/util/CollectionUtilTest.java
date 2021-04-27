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

  @Test
  @DisplayName("리스트에 중복된 요소를 제거하여 리스트를 반환한다.")
  void distinctList() {
    // given
    List<Integer> numbers = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5);

    // when
    List<Integer> actual = CollectionUtil.distinctList(numbers);

    // then
    assertThat(actual)
            .containsExactly(1, 2, 3, 4, 5)
            .hasSize(5);
  }
}