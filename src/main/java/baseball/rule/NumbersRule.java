package baseball.rule;

import baseball.domain.Number;

import java.util.List;

@FunctionalInterface
public interface NumbersRule {
  List<Number> get();
}
