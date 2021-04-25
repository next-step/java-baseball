package baseball.rule;

import java.util.List;

@FunctionalInterface
public interface NumbersRule {
  List<Integer> get();
}
