import logic.BaseballGameCoreLogic;
import process.ProcessController;
import ui.CommandLinePresentator;

public class BaseballGameApplication {

    public static void main(String[] args) {
        ProcessController processController = new ProcessController(new CommandLinePresentator(), new BaseballGameCoreLogic());
        try {
            processController.runProcess();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
