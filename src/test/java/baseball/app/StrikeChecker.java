package baseball.app;

/**
 * @author choijaeyong on 2020/11/14.
 * @project java-baseball
 * @description
 */
public class StrikeChecker {

  public static Score check(char inputScorePosition, char computerScore) {
    if (inputScorePosition == computerScore) {
      return Score.STRIKE;
    }

    return null;
  }
}
