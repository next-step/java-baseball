package controller;

public class InProgress implements Game{
  private static InProgress IN_PROGRESS = new InProgress();

  public static InProgress getInstance() {
    return IN_PROGRESS;
  }

  @Override
  public void execute(BaseballGameRunner runner) {
    runner.pitchBaseBall();
  }
}
