package controller;

import domain.Baseball;
import domain.BaseballNumbers;
import domain.BaseballTokenizer;
import domain.HintCounter;
import view.InputView;
import view.ResultView;

public class BaseballGameRunner {
  private Game game;
  private BaseballTokenizer tokenizer;
  private Baseball gameBaseball;

  public BaseballGameRunner(Game game, BaseballTokenizer tokenizer) {
    this.game = game;
    this.tokenizer = tokenizer;
    this.gameBaseball = new Baseball(BaseballNumbers.create());
  }

  public void run() {
    try {
      game.execute(this);
    } catch (IllegalArgumentException e) {
      ResultView.printExceptionReason(e);
      retry();
    }
  }

  private void retry() {
    run();
  }

  void pitchBaseBall() {
    String inputBaseBall = InputView.inputBaseball();
    Baseball userBaseball = new Baseball(inputBaseBall, tokenizer);
    HintCounter hintCounter = HintCounter.of(userBaseball, gameBaseball);

    if(hintCounter.isAllStrike()) {
      game = new End(hintCounter);
    }

    doResult(hintCounter);
    retry();
  }

  void doResult(HintCounter hintCounter) {
    ResultView.printResult(hintCounter);
  }

  void exit(HintCounter hintCounter) {
  }
}
