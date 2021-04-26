package view;

import domain.Hint;
import domain.HintCounter;

public class ResultView {

  public static void printExceptionReason(IllegalArgumentException exception) {
    System.out.println(exception.getMessage());
  }
  public static void printResult(HintCounter hintCounter) {
    if(hintCounter.isAllNothing()) {
      System.out.println(ViewSymbol.NOTHING_SYMBOL);
      return;
    }

    int strikeCount = hintCounter.getCount(Hint.STRIKE);
    int ballCount = hintCounter.getCount(Hint.BALL);

    System.out.printf("%d%s %d%s\n", strikeCount, ViewSymbol.STRIKE_SYMBOL, ballCount, ViewSymbol.BALL_SYMBOL);
  }
}
