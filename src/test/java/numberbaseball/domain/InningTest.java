package numberbaseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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

  @DisplayName("예상 숫자를 맞춰보고 결과 객체를 반환하는 테스트")
  @MethodSource("provideForComputingScore")
  @ParameterizedTest
  void computeScoreTest(List<Pitching> actual, List<Pitching>  expectation, CountScore result) {
    Inning actualInning = new Inning(actual);
    assertThat(actualInning.computeScore(new Inning( expectation))).isEqualTo(result);
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

  static Stream<Arguments> provideForComputingScore() {
    return Stream.of(
        Arguments.of(List.of(new Pitching(1), new Pitching(2), new Pitching(3)),
                      List.of(new Pitching(1), new Pitching(2), new Pitching(3)),
                      new CountScore(List.of(Count.STRIKE, Count.STRIKE, Count.STRIKE))),
        Arguments.of(List.of(new Pitching(2), new Pitching(6), new Pitching(1)),
                      List.of(new Pitching(2), new Pitching(1), new Pitching(4)),
                      new CountScore(List.of(Count.STRIKE, Count.BALL, Count.NOTHING))),
        Arguments.of(List.of(new Pitching(2), new Pitching(6), new Pitching(1)),
                      List.of(new Pitching(3), new Pitching(4), new Pitching(5)),
                      new CountScore(List.of(Count.NOTHING, Count.NOTHING, Count.NOTHING)))
    );
  }

}
