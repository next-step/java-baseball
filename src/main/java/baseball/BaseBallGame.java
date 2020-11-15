package baseball;

import baseball.app.ComputerNumberCreator;
import baseball.app.ScoreCalculator;
import baseball.app.ScoreTable;
import baseball.ui.InputHandler;
import baseball.ui.PrintHandler;

/**
 * @author choijaeyong on 2020/11/15.
 * @project java-baseball
 * @description
 */
public class BaseBallGame {
  private static int GAME_COIN = 1;
  private static int COMPUTER_NUMBER = 0;

  public static void main(String[] args) {
    COMPUTER_NUMBER = ComputerNumberCreator.create();
    while (GAME_COIN == 1) {
      Integer inputNumber = InputHandler.input();
      ScoreTable calculatedScoreTable = ScoreCalculator.calculate(String.valueOf(COMPUTER_NUMBER), String.valueOf(inputNumber));
      PrintHandler.print(calculatedScoreTable.printScore());
      isContinueGame(calculatedScoreTable);
    }
  }

  private static void isContinueGame(ScoreTable calculatedScoreTable) {
    if (calculatedScoreTable.isSuccessGame()) {
      PrintHandler.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      PrintHandler.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      GAME_COIN = InputHandler.insertCoin();
      COMPUTER_NUMBER = ComputerNumberCreator.create();
    }
  }

}
