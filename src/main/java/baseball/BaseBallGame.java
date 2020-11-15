package baseball;

import baseball.app.ScoreCalculator;
import baseball.app.ScoreTable;
import baseball.ui.ScoreInputer;

/**
 * @author choijaeyong on 2020/11/15.
 * @project java-baseball
 * @description
 */
public class BaseBallGame {
  public static void main(String[] args) {
    int gameCoin = 1;
    while (gameCoin == 1) {
      Integer inputNumber = ScoreInputer.input();
      Integer computerNumber = ComputerNumberCreator.create();
      ScoreCalculator scoreCalculator = new ScoreCalculator();
      ScoreTable calculated = scoreCalculator.calculate(String.valueOf(computerNumber), String.valueOf(inputNumber));
      System.out.println(calculated.printScore());

    }
  }

}
