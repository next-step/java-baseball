package dev.cobi;

import dev.cobi.logics.BaseballGame;
import dev.cobi.logics.RandomNumberGenerator;
import dev.cobi.logics.Referee;
import dev.cobi.view.BaseballGameView;

public class BaseballApp {
  public static void main(String[] args) {
    BaseballGameView baseballGameView = new BaseballGameView();
    Referee referee = new Referee();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    BaseballGame baseballGame = new BaseballGame(baseballGameView, referee, randomNumberGenerator);

    baseballGame.play();
  }
}
