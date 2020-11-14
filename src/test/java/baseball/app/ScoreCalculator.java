package baseball.app;

import java.util.EnumMap;

/**
 * @author choijaeyong on 2020/11/14.
 * @project java-baseball
 * @description
 */
public class ScoreCalculator {

  public ScoreTable calculate(String inputString, String computerString) {
    ScoreTable scoreTable = new ScoreTable();
    for (int i=0 ; i < computerString.length() ; i++) {
      scoreTable.record(StrikeChecker.check(inputString.charAt(i), computerString.charAt(i)));
    }
    return scoreTable;
  }
}
