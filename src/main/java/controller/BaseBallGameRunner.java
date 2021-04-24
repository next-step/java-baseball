package controller;

import view.InputView;

public class BaseBallGameRunner {
  private Game game;

  public BaseBallGameRunner(Game game) {
    this.game = game;
  }

  public void run() {
    game.execute(this);
  }

  void pitchBaseBall() {
    String inputBaseBall = InputView.inputBaseball();
  }
}
