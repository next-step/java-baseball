import controller.BaseBallGameRunner;
import controller.InProgress;
import domain.BaseballTokenizer;

public class Application {
  public static void main(String[] args) {
    BaseBallGameRunner baseBallGameRunner = new BaseBallGameRunner(InProgress.getInstance(), new BaseballTokenizer());
    baseBallGameRunner.run();
  }
}
