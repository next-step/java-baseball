package controller;

import domain.HintCounter;

public class End implements Game {
  private HintCounter hintCounter;

  public End(HintCounter hintCounter) {
    this.hintCounter = hintCounter;
  }

  @Override
  public void execute(BaseballGameRunner runner) {
    runner.exit(hintCounter);
  }
}
