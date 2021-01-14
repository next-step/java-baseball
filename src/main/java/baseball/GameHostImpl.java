package baseball;

public class GameHostImpl implements GameHost {
  private final JudgmentBehavior judgmentBehavior;
  private final PrintBehavior printBehavior;
  private final InputBehavior inputBehavior;

  public GameHostImpl(JudgmentBehavior judgmentBehavior, PrintBehavior printBehavior, InputBehavior inputBehavior) {
    this.judgmentBehavior = judgmentBehavior;
    this.printBehavior = printBehavior;
    this.inputBehavior = inputBehavior;
  }

  @Override
  public void playGame() {
    judgmentBehavior.startNewGame();
    while (judgmentBehavior.isContinueGame()) {
      printBehavior.printStartInnings();
      String oneInnings = inputBehavior.inputOneInnings();
      InningsResult result = judgmentBehavior.getInningsResult(oneInnings);
      printBehavior.printInningsResult(result);
      boolean isFinishGame = inputBehavior.inputIsContinueGame(result);
      judgmentBehavior.checkFinishGame(result, isFinishGame);
    }
  }
}