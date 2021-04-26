package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HintCounterTest {

  @ParameterizedTest
  @CsvSource({
      "'123', '412', 0, 2",
      "'157', '157', 3, 0",
      "'789', '987', 1, 2",
      "'456', '645', 0, 3"
  })
  void 유저야구공과_게임야구공의_예상스트라이크횟수와_예상볼횟수_테스트(String userBaseballSeed, String gameBaseballSeed, int expectedStrikeCount, int expectedBallCount) {
    Baseball userBaseball = new Baseball(userBaseballSeed, new BaseballTokenizer());
    Baseball gameBaseball = new Baseball(gameBaseballSeed, new BaseballTokenizer());

    HintCounter hintCounter = HintCounter.of(userBaseball, gameBaseball);

    int strikeCount = hintCounter.getCount(Hint.STRIKE);
    int ballCount = hintCounter.getCount(Hint.BALL);

    assertThat(strikeCount).isEqualTo(expectedStrikeCount);
    assertThat(ballCount).isEqualTo(expectedBallCount);
  }

  @ParameterizedTest
  @CsvSource({
      "'157', '157', true",
      "'123', '123', true",
      "'123', '124', false",
      "'641', '146', false",
      "'987', '987', true",
  })
  void 유저야구공과_게임야구공의_야구공숫자의_번호와_위치가_모두같다면_전체스트라이크여부는_참을_반환하고_그렇지않다면_거짓을_반환한다(String userBaseballSeed, String gameBaseballSeed, boolean expectedAllStrike) {
    Baseball userBaseball = new Baseball(userBaseballSeed, new BaseballTokenizer());
    Baseball gameBaseball = new Baseball(gameBaseballSeed, new BaseballTokenizer());

    HintCounter hintCounter = HintCounter.of(userBaseball, gameBaseball);

    assertThat(hintCounter.isAllStrike()).isEqualTo(expectedAllStrike);
  }

  @ParameterizedTest
  @CsvSource({
      "'123', '456', true",
      "'123', '356', false",
      "'789', '123', true"
  })
  void 유저야구공이_게임야구공의_모든숫자가_모두_매치되지않는다면_전체낫싱여부는_참을_반환하고_그렇지않다면_거짓을_반환한다(String userBaseballSeed, String gameBaseballSeed, boolean expectedAllNothing) {
    Baseball userBaseball = new Baseball(userBaseballSeed, new BaseballTokenizer());
    Baseball gameBaseball = new Baseball(gameBaseballSeed, new BaseballTokenizer());

    HintCounter hintCounter = HintCounter.of(userBaseball, gameBaseball);

    assertThat(hintCounter.isAllNothing()).isEqualTo(expectedAllNothing);
  }
}