package baseballgame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import baseballgame.exceptions.*;

public class BaseballGame {
  public static final int DIGITS = 3;

  private int[] answer;
  private Map<Integer, Integer> answerMap;

  public void init() {
    this.answer = generateAnswer(new DefaultGenerator());
    constructAnswerMap();
  }

  public void init(AnswerGenerator generator) {
    this.answer = generateAnswer(generator);
    constructAnswerMap();
  }

  private void constructAnswerMap() {
    answerMap = new HashMap<>();
    for (int i = 0; i < DIGITS; i++) {
      answerMap.put(answer[i], i);
    }
  }

  public int[] generateAnswer(AnswerGenerator generator) {
    return generator.generate();
  }

  public void validateInput(int[] input) throws ViolationException {
    checkLength(input);
    for (int i : input) {
      checkOutOfRange(i);
    }
    checkDuplication(input);
  }

  private void checkLength(int[] input) throws ViolationException {
    if (input.length != DIGITS) {
      throw new ViolationException("Input must have length with " + DIGITS + ".");
    }
  }

  private void checkOutOfRange(int i) throws ViolationException {
    if (i > 9 || i < 1) {
      throw new ViolationException("Number " + i + " is out of range.");
    }
  }

  private void checkDuplication(int[] input) throws ViolationException {
    Set<Integer> tempSet = new HashSet<>();
    for (int i : input) {
      tempSet.add(i);
    }
    if (tempSet.size() != DIGITS) {
      throw new ViolationException("No duplication allowed for input.");
    }
  }

  public Result matchWithAnswer(int[] input) {
    Result result = new Result();
    for (int i = 0; i < DIGITS; i++) {
      result.strikes += checkIfStrike(i, input[i]);
    }
    for (int i = 0; i < DIGITS; i++) {
      result.balls += checkIfBall(i, input[i]);
    }
    return result;
  }

  private int checkIfStrike(int pos, int value) {
    if (answer[pos] == value) {
      return 1;
    }
    return 0;
  }

  private int checkIfBall(int pos, int value) {
    Integer valuePos = answerMap.get(value);
    if (valuePos != null && valuePos != pos) {
      return 1;
    }
    return 0;
  }

}
