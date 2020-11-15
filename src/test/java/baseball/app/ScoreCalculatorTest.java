package baseball.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/11/11.
 * @project java-baseball
 * @description
 */
public class ScoreCalculatorTest {

  @DisplayName("점수를 입력하면 점수표가 생성된다")
  @Test
  public void givenStringGetScoreTable() {
    String computerString = "713";
    assertThat(calculateScore(computerString, "713")).containsEntry(Score.STRIKE,3);
    assertThat(calculateScore(computerString, "714")).containsEntry(Score.STRIKE,2);
    assertThat(calculateScore(computerString, "216")).containsEntry(Score.STRIKE,1);
    assertThat(calculateScore(computerString, "245")).isEmpty();
    assertThat(calculateScore(computerString, "145")).containsKey(Score.BALL).containsValue(1);
    assertThat(calculateScore(computerString, "134")).containsKey(Score.BALL).containsValue(2);
    assertThat(calculateScore(computerString, "137")).containsKey(Score.BALL).containsValue(3);
    assertThat(calculateScore(computerString, "734")).containsEntry(Score.STRIKE,1).containsEntry(Score.BALL,1);
    assertThat(calculateScore(computerString, "295")).isEmpty();
  }

  private EnumMap<Score, Integer> calculateScore(String computerString, String inputString) {
    return ScoreCalculator.calculate(computerString, inputString).getScoreMap();
  }
}
