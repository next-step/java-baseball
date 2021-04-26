package controller;

import domain.Baseball;
import domain.BaseballNumbers;
import domain.BaseballTokenizer;
import domain.HintCounter;
import view.InputView;
import view.ResultView;

public class BaseBallGameRunner {
  private Game game;
  private BaseballTokenizer tokenizer;
  private Baseball gameBaseball;

  public BaseBallGameRunner(Game game, BaseballTokenizer tokenizer) {
    this.game = game;
    this.tokenizer = tokenizer;
    this.gameBaseball = new Baseball(BaseballNumbers.create());
  }

  public void run() {
    game.execute(this);
  }

  void pitchBaseBall() {
    String inputBaseBall = InputView.inputBaseball();
    Baseball userBaseball = new Baseball(inputBaseBall, tokenizer);
    HintCounter hintCounter = HintCounter.of(userBaseball, gameBaseball);
    doResult(hintCounter);
  }
  void doResult(HintCounter hintCounter) {
    ResultView.printResult(hintCounter);
  }
}
