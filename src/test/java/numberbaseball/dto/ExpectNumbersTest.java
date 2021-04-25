package numberbaseball.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpectNumbersTest {

  @DisplayName("객체 생성 테스트")
  @ValueSource(ints = {123, 469, 815})
  @ParameterizedTest
  void constructionTest(int given) {
    assertThat(new ExpectNumbers(given)).isEqualTo(new ExpectNumbers(given));
  }

  @DisplayName("객체 생성 실패 테스트")
  @ValueSource(ints = {1234, 12, 112})
  @ParameterizedTest
  void constructionFailTest(int given) {
    assertThatThrownBy(() -> new ExpectNumbers(given)).isInstanceOf(IllegalArgumentException.class);
  }


}
