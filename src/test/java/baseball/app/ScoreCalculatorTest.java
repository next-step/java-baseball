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
    String computerString = "123";
    assertThat(scoreCalculator.calculate("123", computerString)).containsKey(Score.STRIKE).containsValue(3);
    assertThat(scoreCalculator.calculate("124", computerString)).containsKey(Score.STRIKE).containsValue(2);
    assertThat(scoreCalculator.calculate("134", computerString)).containsKey(Score.STRIKE).containsValue(1);
    assertThat(scoreCalculator.calculate("555", computerString)).doesNotContainKey(Score.STRIKE).isEmpty();
  }

}
