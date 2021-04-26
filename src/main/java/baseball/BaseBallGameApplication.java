package baseball;

import baseball.domain.BallRecord;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.rule.OperatorNumbersRule;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseBallGameApplication {

  public static void main(String[] args) {
    do {
      startGame();
    } while (InputView.isRestart(InputView.getRestartOrEndGame()));
  }

  private static void startGame() {
    Computer computer = Computer.generate(new OperatorNumbersRule());

    boolean isStrikeOut = false;
    while (!isStrikeOut) {
      Player player = Player.generateNumberString(InputView.getNumberString());
      BallRecord record = computer.resultOf(player);
      ResultView.print(record);
      isStrikeOut = record.isStrikeOut();
    }
  }
}
