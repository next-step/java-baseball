package numberbaseball.dto;

import numberbaseball.domain.Inning;
import numberbaseball.domain.Pitching;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

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

  @DisplayName("Inning 도메인 객체로 변환 테스트")
  @MethodSource("provideExpectNumberAndInning")
  @ParameterizedTest
  void transformToInningTest(ExpectNumbers expectNumbers, Inning inning) {
    assertThat(expectNumbers.transFormToInning()).isEqualTo(inning);
  }

  static Stream<Arguments> provideExpectNumberAndInning() {
    return Stream.of(
        Arguments.of(new ExpectNumbers(123), new Inning(List.of(new Pitching(1), new Pitching(2), new Pitching(3)))),
        Arguments.of(new ExpectNumbers(915), new Inning(List.of(new Pitching(9), new Pitching(1), new Pitching(5))))
    );
  }


}
