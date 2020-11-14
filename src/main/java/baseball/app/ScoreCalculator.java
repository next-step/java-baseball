package baseball.app;

/**
 * @author choijaeyong on 2020/11/14.
 * @project java-baseball
 * @description
 */
public class ScoreCalculator {

  public ScoreTable calculate(String computerString, String inputString) {
    ScoreTable scoreTable = new ScoreTable();
    for (int i=0 ; i < inputString.length() ; i++) {
      Score score = StrikeValidator.validStrike(computerString, inputString, i);
      scoreTable.recordScore(score);
    }
    return scoreTable;
  }
}
