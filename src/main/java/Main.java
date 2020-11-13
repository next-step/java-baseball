import domain.BaseballNumber;
import domain.ComputerNumber;
import domain.MatchMachine;
import domain.Score;
import ui.InputView;
import ui.ResultView;

public class Main {
    private static boolean isEnd = false;

    private static void baseballGame(ComputerNumber computerNumber, MatchMachine matchMachine) {
        Score score = new Score();
        while (!score.isAllStrike()) {
            int number = InputView.inputNumber();
            BaseballNumber baseballNumber = new BaseballNumber(String.valueOf(number));
            score = matchMachine.compare(baseballNumber.getNumber());
            score.printScore();
        }
    }

    public static void main(String[] args) {
        int button = 1;
        while (button == 1) {
            ComputerNumber computerNumber = new ComputerNumber();
            MatchMachine matchMachine = new MatchMachine(computerNumber.getNumber());
            baseballGame(computerNumber, matchMachine);
            ResultView.endMessage();

            button = InputView.restartOrEnd();
        }
    }
}
