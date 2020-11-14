package baseball.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author choijaeyong on 2020/11/11.
 * @project java-baseball
 * @description
 */
public class ScoreCalculatorTest {
  private ScoreCalculator scoreCalculator;

  @BeforeEach
  public void setUp() {
    scoreCalculator = new ScoreCalculator();
  }

  @DisplayName("점수를 입력하면 점수표가 출력")
  @Test
  public void givenStringGetResult() {
    String computerString = "713";
    assertThat(scoreCalculator.calculate("713", computerString).getScoreMap()).containsEntry(Score.STRIKE,3);
    assertThat(scoreCalculator.calculate("714", computerString).getScoreMap()).containsEntry(Score.STRIKE,2);
    assertThat(scoreCalculator.calculate("216", computerString).getScoreMap()).containsEntry(Score.STRIKE,1);
    assertThat(scoreCalculator.calculate("245", computerString).getScoreMap()).containsEntry(Score.STRIKE,0);
    assertThat(scoreCalculator.calculate("145", computerString).getScoreMap()).containsKey(Score.BALL).containsValue(1);
    assertThat(scoreCalculator.calculate("134", computerString).getScoreMap()).containsKey(Score.BALL).containsValue(2);
    assertThat(scoreCalculator.calculate("137", computerString).getScoreMap()).containsKey(Score.BALL).containsValue(3);
  }

}
