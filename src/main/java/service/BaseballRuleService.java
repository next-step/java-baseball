package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballRuleService {

  private final List<Integer> input;
  private final List<Integer> answer;

  public BaseballRuleService(List<Integer> input, List<Integer> answer) {
    this.input = input;
    this.answer = answer;
  }

  public boolean checkStrikeAndBall() {
    int strikeCount = getStrikeCount();
    int ballCount = getBallCount(strikeCount);
    System.out.println(BaseballRule.getPrintRuleName(strikeCount, ballCount));
    return strikeCount == 3;
  }

  public int getStrikeCount() {
    int count = 0;
    for (int i = 0; i < answer.size(); i ++) {
      count += (answer.get(i).equals(input.get(i)) ? 1 : 0);
    }
    return count;
  }

  public int getBallCount(int strikeCount) {
    Set<Integer> totalSet = new HashSet<>(answer);
    totalSet.addAll(input);
    return answer.size() + input.size() - strikeCount - totalSet.size();
  }

}
