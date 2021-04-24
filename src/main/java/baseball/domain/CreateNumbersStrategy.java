package baseball.domain;

import java.util.Set;

@FunctionalInterface
public interface CreateNumbersStrategy {
  Set<Integer> createNumbers();

}
