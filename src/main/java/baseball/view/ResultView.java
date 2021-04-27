package baseball.view;

import baseball.domain.ScoreBoard;

public class ResultView {
  private static final String SUCCESS = "3 스트라이크";

  public static void printScore(ScoreBoard scoreBoard) {
    String scoreResult = scoreBoard.getScores();
    System.out.println(scoreResult);
    if (SUCCESS.equals(scoreResult)) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
  }

  public static void printRestart() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2 를 입력하세요.");
  }
}
