package numberbaseball.domain;

import numberbaseball.dto.ExpectResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseballGameTest {

  @DisplayName("객체 생성 테스트")
  @MethodSource("provideStrategy")
  @ParameterizedTest
  void constructionTest(Supplier<Inning> given) {
    assertThat(BaseballGame.createNewGame(given)).isEqualTo(BaseballGame.createNewGame(given));
  }

  @DisplayName("첫 생성시 isOver는 false")
  @Test
  void firstIsOverTest() {
    Supplier<Inning> given = () -> new Inning(List.of(new Pitching(1), new Pitching(2), new Pitching(3)));
    assertThat(BaseballGame.createNewGame(given).isOver()).isFalse();
  }

  @DisplayName("3 스트라이크면 메세지 출력 후 isOver true, 그 외에는 메세지 출력 후 isOver false")
  @MethodSource("provideStrategyAndExpectationAndResultMessage")
  @ParameterizedTest
  void matchExpectationTest(Supplier<Inning> givenStrategy, Inning givenExpectation, boolean expectOverFlag, String expectMessage) {
    BaseballGame newGame = BaseballGame.createNewGame(givenStrategy);
    ExpectResult result = newGame.matchExpectation(givenExpectation);
    assertAll(
        () -> assertThat(newGame.isOver()).isEqualTo(expectOverFlag),
        () -> assertThat(result.getMessage()).isEqualTo(expectMessage)
    );

  }

  static Stream<Supplier<Inning>> provideStrategy() {
    return Stream.of(
        () -> new Inning(List.of(new Pitching(1), new Pitching(2), new Pitching(3))),
        () -> new Inning(List.of(new Pitching(4), new Pitching(5), new Pitching(6)))
    );
  }

  static Stream<Arguments> provideStrategyAndExpectationAndResultMessage() {
    return Stream.of(
        Arguments.of(
            (Supplier<Inning>) () -> new Inning(List.of(new Pitching(1), new Pitching(2), new Pitching(3))),
            new Inning(List.of(new Pitching(1), new Pitching(2), new Pitching(3))),
            true,
            "3 스트라이크 "
        ),
        Arguments.of(
            (Supplier<Inning>) () -> new Inning(List.of(new Pitching(4), new Pitching(5), new Pitching(6))),
            new Inning(List.of(new Pitching(5), new Pitching(2), new Pitching(6))),
            false,
            "1 스트라이크 1 볼 "
        ),
        Arguments.of(
            (Supplier<Inning>) () -> new Inning(List.of(new Pitching(7), new Pitching(8), new Pitching(9))),
            new Inning(List.of(new Pitching(5), new Pitching(2), new Pitching(6))),
            false,
            "낫싱"
        )
    );
  }

}
