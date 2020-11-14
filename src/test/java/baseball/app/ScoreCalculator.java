package baseball.app;

/**
 * @author choijaeyong on 2020/11/14.
 * @project java-baseball
 * @description
 */
public class ScoreCalculator {

  public ScoreTable calculate(String inputString, String computerString) {
    ScoreTable scoreTable = new ScoreTable();
    for (int i=0 ; i < computerString.length() ; i++) {
      Score strikeOrBall = isStrikeOrBall(inputString, computerString, i);
      scoreTable.recordScore(strikeOrBall);
    }
    return scoreTable;
  }

  private Score isStrikeOrBall(String inputString, String computerString, int i) {
    if (inputString.charAt(i) == computerString.charAt(i)) {
      return Score.STRIKE;
    }

    if (computerString.indexOf(inputString.charAt(i)) != -1) {
      return Score.BALL;
    }
    return null;
  }
}
