package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballTokenizerTest {
  BaseballTokenizer tokenizer = new BaseballTokenizer();

  @ParameterizedTest
  @CsvSource({
      "'123', 1, 2, 3",
      "'456', 4, 5, 6",
      "'789', 7, 8, 9"
  })
  void 문자열로_이루어진_Baseball을_한자리씩_분할하여_리스트로_만든다(String inputBaseball, int expected1, int expected2, int expected3) {
    List<Integer> tokens = tokenizer.tokenize(inputBaseball);
    assertThat(tokens.get(0)).isEqualTo(expected1);
    assertThat(tokens.get(1)).isEqualTo(expected2);
    assertThat(tokens.get(2)).isEqualTo(expected3);
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "abc", "1a9", "!23", "44_",
  })
  void 숫자형태의_문자열이_아닌경우_예외가발생한다() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      tokenizer.tokenize("abc");
    });
    assertThat(exception.getMessage()).isEqualTo("숫자형태의 문자가아닙니다.");
  }

  @ParameterizedTest
  @CsvSource({
      "'123 ', 1, 2, 3",
      "' 123 ', 1, 2, 3"
  })
  void 처음_혹은_끝_문자가_공백문자라면_생략되어_token화된다(String inputBaseball, int expected1, int expected2, int expected3) {
    List<Integer> tokens = tokenizer.tokenize(inputBaseball);
    assertThat(tokens.get(0)).isEqualTo(expected1);
    assertThat(tokens.get(1)).isEqualTo(expected2);
    assertThat(tokens.get(2)).isEqualTo(expected3);
  }
}