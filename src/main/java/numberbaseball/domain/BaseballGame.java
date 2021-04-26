package numberbaseball.domain;

import numberbaseball.dto.ExpectResult;

import java.util.Objects;
import java.util.function.Supplier;

public class BaseballGame {

  private final Inning prepared;
  private boolean over = false;

  private BaseballGame(Inning preparedInning) {
    this.prepared = preparedInning;
  }

  public static BaseballGame createNewGame(Supplier<Inning> inningPrepareStrategy) {
    return new BaseballGame(inningPrepareStrategy.get());
  }

  public boolean isOver() {
    return over;
  }

  public ExpectResult matchExpectation(Inning expectation) {
    CountScore countScoreOfExpectation = prepared.computeScore(expectation);
    this.over = countScoreOfExpectation.isGameOverScore();
    return new ExpectResult(countScoreOfExpectation);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BaseballGame that = (BaseballGame) o;
    return over == that.over && prepared.equals(that.prepared);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prepared, over);
  }
}
