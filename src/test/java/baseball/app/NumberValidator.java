package baseball.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author choijaeyong on 2020/11/15.
 * @project java-baseball
 * @description
 */
public class NumberValidator {

  public boolean valid(int number) {
    String numberString = String.valueOf(number);
    if(numberString.length() != 3) return false;
    Set<String> set = new HashSet<String>();
    for (char numberChar : numberString.toCharArray()) {
      set.add(String.valueOf(numberChar));
    }
    return set.size() == numberString.length();
  }
}
