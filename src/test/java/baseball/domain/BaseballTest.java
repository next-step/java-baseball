package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballTest {

  @Test
  @DisplayName("baseball 의 사이즈가 3이 아니면 illegalArgumentsException")
  void createBaseball_fail_size() {
    List<BaseballNumber> baseballNumbers = Arrays.asList(new BaseballNumber(1), new BaseballNumber(2));

    assertThatIllegalArgumentException()
        .isThrownBy(() -> new BaseBall(baseballNumbers))
        .withMessage(BaseBall.SIZE_ERROR_MESSAGE);
  }

  @Test
  @DisplayName("baseball 을 생성할 때, 동일한값이 있으면, illegalArgumentsException")
  void createBaseball_fail_equals() {
    List<BaseballNumber> baseballNumbers
        = Arrays.asList(new BaseballNumber(1), new BaseballNumber(1), new BaseballNumber(3));

    assertThatIllegalArgumentException()
        .isThrownBy(() -> new BaseBall(baseballNumbers))
        .withMessage(BaseBall.EQUALS_VALUE_ERROR_MESSAGE);
  }

  @ParameterizedTest
  @CsvSource(value = {"1,2,4,2", "1,3,2,3", "5,6,7,0"})
  @DisplayName("포함하고 있는 갯수를 구한다.")
  void getContainsCount(int first, int second, int third, int expected) {
    List<BaseballNumber> baseballNumbers
        = Arrays.asList(new BaseballNumber(1), new BaseballNumber(2), new BaseballNumber(3));
    BaseBall baseBall = new BaseBall(baseballNumbers);

    List<Integer> playBallNumbers
        = Arrays.asList(first, second, third);
    BaseBall playBall = BaseBall.createPlayBall(playBallNumbers);

    assertEquals(baseBall.getContainsCount(playBall), expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"1,3,2,1", "1,2,3,3", "5,6,7,0"})
  @DisplayName("스트라이크 갯수를 구한다.")
  void getStrikeCount(int first, int second, int third, int expected) {
    List<BaseballNumber> baseballNumbers
        = Arrays.asList(new BaseballNumber(1), new BaseballNumber(2), new BaseballNumber(3));
    BaseBall baseBall = new BaseBall(baseballNumbers);

    List<Integer> playBallNumbers
        = Arrays.asList(first, second, third);
    BaseBall playBall = BaseBall.createPlayBall(playBallNumbers);

    assertEquals(baseBall.getStrikeCount(playBall), expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"1,3,2,2", "1,2,3,0", "2,3,1,3"})
  @DisplayName("스트라이크 갯수를 구한다.")
  void getBallCount(int first, int second, int third, int expected) {
    List<BaseballNumber> baseballNumbers
        = Arrays.asList(new BaseballNumber(1), new BaseballNumber(2), new BaseballNumber(3));
    BaseBall baseBall = new BaseBall(baseballNumbers);

    List<Integer> playBallNumbers
        = Arrays.asList(first, second, third);
    BaseBall playBall = BaseBall.createPlayBall(playBallNumbers);

    assertEquals(baseBall.getBallCount(playBall), expected);
  }
}
