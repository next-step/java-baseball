package numberbaseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static numberbaseball.domain.Count.*;
import static org.assertj.core.api.Assertions.assertThat;

class CountScoreTest {

  @DisplayName("객체 생성 테스트")
  @MethodSource("provideCountList")
  @ParameterizedTest
  void constructionTest(List<Count> given) {
    assertThat(new CountScore(given)).isEqualTo(new CountScore(given));
  }

  static Stream<Arguments> provideCountList() {
    return Stream.of(
        Arguments.of(List.of(STRIKE, STRIKE, STRIKE)),
        Arguments.of(List.of(STRIKE, BALL, NOTHING)),
        Arguments.of(List.of(NOTHING, BALL, NOTHING))
    );
  }

}
