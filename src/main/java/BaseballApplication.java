import baseball.controller.BaseballController;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballApplication {

  public static void main(String[] args) {
    BaseballController baseballController = new BaseballController();
    int coin = 1;

    while (coin == 1) {
      baseballController.gameStart();
      ResultView.printRestart();
      coin = InputView.insertCoin();
    }


  }

}
