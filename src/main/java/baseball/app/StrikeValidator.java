package baseball.app;

/**
 * @author choijaeyong on 2020/11/14.
 * @project java-baseball
 * @description
 */
public class StrikeValidator {

  public static Score validStrike(String inputString, String computerString, int i) {
    if (inputString.charAt(i) == computerString.charAt(i)) {
      return Score.STRIKE;
    }

    if (computerString.indexOf(inputString.charAt(i)) != -1) {
      return Score.BALL;
    }

    return Score.NONE;
  }

}
