package baseball.view;

import baseball.domain.ScoreBoard;

public class ResultView {

  public static void printScore(ScoreBoard scoreBoard) {
    System.out.println(scoreBoard.getScores());
  }
}
