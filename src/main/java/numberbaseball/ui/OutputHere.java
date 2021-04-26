package numberbaseball.ui;

import numberbaseball.dto.ExpectResult;

public class OutputHere {

  private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

  private OutputHere() {}

  public static void printExpectResult(ExpectResult expectResult) {
    System.out.println(expectResult.getMessage());
  }

  public static void printGameOverMessage() {
    System.out.println(GAME_OVER_MESSAGE);
  }
}
