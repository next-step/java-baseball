import domain.BaseballNumbers;
import domain.BaseballResult;
import utils.BaseballRandomNumber;
import utils.UtilMeassage;
import view.InputView;
import view.OutputView;

public class BaseballGameApplication {
    public static void main(String[] args) {
        do {
            System.out.println(UtilMeassage.START);
            BaseballNumbers answerBaseball = BaseballRandomNumber.simulationRandomNumber();
            play(answerBaseball);
        } while(InputView.playAgain());

    }

    public static void play(BaseballNumbers answer) {
        boolean isAnswer;
        do {
            BaseballNumbers userBaseball = InputView.userInputValue();
            BaseballResult result = answer.match(userBaseball);
            isAnswer = OutputView.showResult(result);
        } while (!isAnswer);

    }
}
