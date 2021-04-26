package domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballTokenizer {
  public List<Integer> tokenize(String inputBaseball) {
    List<Integer> tokens = new ArrayList<>();
    char[] splitBaseball = inputBaseball.trim().toCharArray();

    for (char c : splitBaseball) {
      validate(c);
      tokens.add(convertCharToInt(c));
    }

    return tokens;
  }

  private void validate(char c) {
    if(isNotNumber(c)) {
      throw new IllegalArgumentException("숫자형태의 문자가아닙니다.");
    }
  }

  private boolean isNotNumber(char c) {
    return !( c >= '0' && c <= '9');
  }

  private int convertCharToInt(char c) {
    return c - '0';
  }

}
