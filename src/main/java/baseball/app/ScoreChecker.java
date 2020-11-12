package baseball.app;

import java.util.EnumMap;

/**
 * @author choijaeyong on 2020/11/11.
 * @project java-baseball
 * @description
 */
public class ScoreChecker {

  public EnumMap<Score,Integer> check(String inputString, String computerString) {
    EnumMap<Score,Integer> map = new EnumMap<Score, Integer>(Score.class);
    for (int i=0 ; i < computerString.length() ; i++) {
      if (computerString.charAt(i) == inputString.charAt(i)) {
        map.put(Score.STRIKE, map.get(Score.STRIKE) == null ? 1 : map.get(Score.STRIKE) + 1);
      }
    }
    return map;
  }
}
