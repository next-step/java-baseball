package numberbaseball;

import numberbaseball.domain.BaseballGame;
import numberbaseball.domain.Inning;
import numberbaseball.dto.ExpectNumbers;
import numberbaseball.dto.ExpectResult;
import numberbaseball.ui.InputHere;
import numberbaseball.ui.OutputHere;

import java.util.function.Supplier;

public class Main {

  public static void main(String[] args) {
    boolean gamePlayFlag = true;
    Supplier<Inning> newGameInningStrategy = Inning::generateRandomInning;
    while (gamePlayFlag) {
      BaseballGame newGame = BaseballGame.createNewGame(newGameInningStrategy);
      playBaseballGame(newGame);
      OutputHere.printGameOverMessage();
      gamePlayFlag = InputHere.getContinueFlag();
    }
  }

  private static void playBaseballGame(BaseballGame baseballGame) {
    while (!baseballGame.isOver()) {
      ExpectNumbers expectNumbers = InputHere.getExpectNumbers();
      ExpectResult expectResult = baseballGame.matchExpectation(expectNumbers.transFormToInning());
      OutputHere.printExpectResult(expectResult);
    }
  }
}
