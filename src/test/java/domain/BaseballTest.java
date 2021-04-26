package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballTest {

  @ParameterizedTest
  @DisplayName("유저야구공 생성 테스트")
  @CsvSource({
      "'123', 1, 2, 3",
      "456, 4, 5, 6",
      "789, 7, 8, 9"
  })
  void 유저입력문자열과_토크나이저를_생성자로_입력_받아_BaseballNumbers를_가진_객체를_생성한다(String inputBaseball, int expected1, int expected2, int expected3) {
    Baseball baseball = new Baseball(inputBaseball, new BaseballTokenizer());
    BaseballNumbers baseballNumbers = baseball.getBaseballNumbers();
    assertThat(baseballNumbers.size()).isEqualTo(3);
    assertThat(baseballNumbers.getBaseballNumbers().get(0)).isEqualTo(BaseballNumber.from(expected1));
    assertThat(baseballNumbers.getBaseballNumbers().get(1)).isEqualTo(BaseballNumber.from(expected2));
    assertThat(baseballNumbers.getBaseballNumbers().get(2)).isEqualTo(BaseballNumber.from(expected3));
  }

  @RepeatedTest(10)
  @DisplayName("게임야구공 생성 테스트")
  void 게임에서생성된_BaseballNumbers를_생성자로_입력_받아_BaseballNumbers를_가진_객체를_생성한다() {
    Baseball baseball = new Baseball(BaseballNumbers.create());
    BaseballNumbers baseballNumbers = baseball.getBaseballNumbers();
    assertThat(baseballNumbers.size()).isEqualTo(3);
  }
}