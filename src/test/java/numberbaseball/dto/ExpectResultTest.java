package numberbaseball.dto;

import numberbaseball.domain.Count;
import numberbaseball.domain.CountScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ExpectResultTest {

  @DisplayName("객체 생성 테스트")
  @MethodSource("provideCountScore")
  @ParameterizedTest
  void constructionTest(CountScore given) {
    assertThat(new ExpectResult(given)).isEqualTo(new ExpectResult(given));
  }

  @DisplayName("예상 한 대로 출력 메세지가 나오는지 테스트")
  @MethodSource("provideCountScoreAndMessage")
  @ParameterizedTest
  void getMessageTest(CountScore given, String expectation) {
    assertThat(new ExpectResult(given).getMessage()).isEqualTo(expectation);
  }

  static Stream<CountScore> provideCountScore() {
    return Stream.of(
        new CountScore(List.of(Count.STRIKE, Count.STRIKE, Count.STRIKE)),
        new CountScore(List.of(Count.NOTHING, Count.NOTHING, Count.NOTHING)),
        new CountScore(List.of(Count.STRIKE, Count.BALL, Count.NOTHING))
    );
  }

  static Stream<Arguments> provideCountScoreAndMessage() {
    return Stream.of(
        Arguments.of(new CountScore(List.of(Count.STRIKE, Count.STRIKE, Count.STRIKE)), "3 스트라이크 "),
        Arguments.of(new CountScore(List.of()), "낫싱"),
        Arguments.of(new CountScore(List.of(Count.STRIKE, Count.BALL)), "1 스트라이크 1 볼 ")
    );
  }

}
