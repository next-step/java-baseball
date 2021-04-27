package dev.cobi.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author cobiyu
 */
class ResultScoreTest {

  @Test
  @DisplayName("스트라이크 3회 이상으로 동작할 수 없다.")
  public void PreventPlayOverThreeStrike(){
    ResultScore resultScore = new ResultScore();
    resultScore.addResultType(ResultType.STRIKE);
    resultScore.addResultType(ResultType.STRIKE);
    resultScore.addResultType(ResultType.STRIKE);

    assertThrows(IllegalArgumentException.class, () -> resultScore.addResultType(ResultType.STRIKE));
  }

  @Test
  @DisplayName("볼 3회 이상으로 동작할 수 없다.")
  public void PreventPlayOverThreeBall(){
    ResultScore resultScore = new ResultScore();
    resultScore.addResultType(ResultType.STRIKE);
    resultScore.addResultType(ResultType.BALL);
    resultScore.addResultType(ResultType.BALL);
    resultScore.addResultType(ResultType.BALL);

    assertThrows(IllegalArgumentException.class, () -> resultScore.addResultType(ResultType.BALL));
  }

  @Test
  @DisplayName("3스트라이크의 isCorrect()는 true")
  public void ThreeStrikeIsCorrect(){
    ResultScore resultScore = new ResultScore();
    resultScore.addResultType(ResultType.STRIKE);
    resultScore.addResultType(ResultType.STRIKE);
    resultScore.addResultType(ResultType.STRIKE);

    assertTrue(resultScore.isCorrect());
  }
}
