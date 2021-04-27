package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

  @Test
  @DisplayName("문자열을 Integer 리스트로 반환한다.")
  void toIntegerList() {
    // given
    String str = "123";

    // when
    List<Integer> actual = StringUtil.toIntegerList(str);

    // then
    assertThat(actual)
            .containsExactly(1, 2, 3);
  }

  @Test
  @DisplayName("문자열을 구분자 \",\" 를 기준으로 split 한다.")
  void split() {
    // given
    String str = "123";

    // when
    String[] arr = StringUtil.split(str);

    // then
    assertThat(arr).hasSize(3);
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("문자열이 null or 빈공백 문자열일 경우 \"\" 반환한다.")
  void defaultString(String blank) {
    // given

    // when
    String actual = StringUtil.defaultString(blank);

    // then
    assertThat(actual).isEqualTo("");
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("null or 빈공백 문자열일 경우 true 반환한다.")
  void isBlank(String blank) {
    // given

    // when
    boolean actual = StringUtil.isBlank(blank);

    // then
    assertThat(actual).isTrue();
  }
}