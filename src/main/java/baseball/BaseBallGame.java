package baseball;

import baseball.app.ScoreCalculator;
import baseball.app.ScoreTable;
import baseball.ui.ScoreInputer;
import baseball.ui.ScorePrinter;

/**
 * @author choijaeyong on 2020/11/15.
 * @project java-baseball
 * @description
 */
public class BaseBallGame {
  private static int GAME_COIN = 1;

  public static void main(String[] args) {
    while (GAME_COIN == 1) {
      Integer inputNumber = ScoreInputer.input();
      Integer computerNumber = ComputerNumberCreator.create();
      ScoreTable calculated = ScoreCalculator.calculate(String.valueOf(computerNumber), String.valueOf(inputNumber));
      ScorePrinter.print(calculated.printScore());
      if (calculated.isGameSuccess()) {
        ScorePrinter.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        ScorePrinter.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        GAME_COIN = ScoreInputer.insertCoin();
      }
    }
  }

}
