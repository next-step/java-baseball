import controller.BaseBallGameRunner;
import controller.InProgress;

public class Application {
  public static void main(String[] args) {
    BaseBallGameRunner baseBallGameRunner = new BaseBallGameRunner(InProgress.getInstance());
    baseBallGameRunner.run();
  }
}
