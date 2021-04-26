import controller.BaseballGameRunner;
import controller.InProgress;
import domain.BaseballTokenizer;

public class Application {
  public static void main(String[] args) {
    BaseballGameRunner baseBallGameRunner = new BaseballGameRunner(InProgress.getInstance(), new BaseballTokenizer());
    baseBallGameRunner.run();
  }
}
