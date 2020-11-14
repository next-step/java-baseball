package baseball.app;

/**
 * @author choijaeyong on 2020/11/14.
 * @project java-baseball
 * @description
 */
public class ScoreCalculator {

  public ScoreTable calculate(String inputString, String computerString) {
    ScoreTable scoreTable = new ScoreTable();
    scoreTable.strikeRecord(countStrike(inputString,computerString));
    scoreTable.ballRecord(countBall(inputString,computerString));
    return scoreTable;
  }

  private int countBall(String inputString, String computerString) {
    int ballCount = 0;
    for (int i=0 ; i < computerString.length() ; i++) {
      ballCount += computerString.indexOf(inputString.charAt(i)) == -1 ? 0 : 1;
    }
    return ballCount;
  }

  private Integer countStrike(String inputString, String computerString) {
    int strikeCount = 0;
    for (int i=0 ; i < computerString.length() ; i++) {
      strikeCount += isStrike(inputString.charAt(i), computerString.charAt(i));
    }
    return strikeCount;
  }

  private int isStrike(char input, char computer) {
    if (input == computer) {
      return 1;
    }
    return 0;
  }
}
