package baseball.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/11/11.
 * @project java-baseball
 * @description
 */
public class ScoreCheckerTest {

  @Test
  public void context() {

  }

  @Test
  @DisplayName("스트라이크 테스트")
  public void checkStrike() {
    String inputString = "123";
    String computerString = "123";
    ScoreChecker scoreChecker = new ScoreChecker();

    EnumMap<Score,Integer> result = scoreChecker.check(inputString, computerString);
    assertThat(result.get(Score.STRIKE)).isEqualTo(3);

    String inputString2 = "143";
    EnumMap<Score,Integer> result2 = scoreChecker.check(inputString2, computerString);
    assertThat(result2.get(Score.STRIKE)).isEqualTo(2);

    String inputString3 = "145";
    EnumMap<Score,Integer> result3 = scoreChecker.check(inputString3, computerString);
    assertThat(result3.get(Score.STRIKE)).isEqualTo(1);

  }

}
