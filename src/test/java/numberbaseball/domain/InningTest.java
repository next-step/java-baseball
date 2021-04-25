package numberbaseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InningTest {

  @DisplayName("객체 생성 테스트")
  @MethodSource("provideForConstruction")
  @ParameterizedTest
  void constructionTest(List<Pitching> given) {
    assertThat(new Inning(given)).isEqualTo(new Inning(given));
  }

  @DisplayName("객체 생성 실패 테스트")
  @MethodSource("provideForFailConstruction")
  @ParameterizedTest
  void constructionFailTest(List<Pitching> given) {
    assertThatThrownBy(() -> new Inning(given)).isInstanceOf(IllegalArgumentException.class);
  }

  static Stream<List<Pitching>> provideForConstruction() {
    return Stream.of(
        List.of(new Pitching(1), new Pitching(2), new Pitching(3)),
        List.of(new Pitching(8), new Pitching(5), new Pitching(3)),
        List.of(new Pitching(7), new Pitching(1), new Pitching(9))
    );
  }

  static Stream<List<Pitching>> provideForFailConstruction() {
    return Stream.of(
        List.of(new Pitching(1), new Pitching(1), new Pitching(3)),
        List.of(new Pitching(8), new Pitching(5))
    );
  }

}
