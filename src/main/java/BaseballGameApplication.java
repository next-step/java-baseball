import logic.BaseballGameCoreLogic;
import process.ProcessController;
import ui.CommandLinePresentator;

public class BaseballGameApplication {

    public static void main(String[] args) {
        ProcessController processController = new ProcessController(new CommandLinePresentator(), new BaseballGameCoreLogic());
        processController.runProcess();
    }
}
