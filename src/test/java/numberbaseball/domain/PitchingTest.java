package numberbaseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PitchingTest {

  @DisplayName("객체 생성 테스트")
  @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
  @ParameterizedTest
  void constructionTest(int given) {
    assertThat(new Pitching(given)).isEqualTo(new Pitching(given));
  }

  @DisplayName("객체 생성 실패 테스트")
  @ValueSource(ints = {-1,0,10,100})
  @ParameterizedTest
  void constructionFailTest(int given) {
    assertThatThrownBy(() -> new Pitching(given)).isInstanceOf(IllegalArgumentException.class)
                                                .hasMessageContaining("1 부터 9 사이의 값을 입력해주세요.");
  }

}
