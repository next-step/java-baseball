import domain.BaseballNumber;
import domain.ComputerNumber;
import domain.MatchMachine;
import domain.Score;
import ui.InputView;
import ui.ResultView;

public class Main {
    private static boolean isEnd = false;

    public static void main(String[] args) {
        int button = 1;
        while (button == 1) {
            playBaseballGame();
            ResultView.endMessage();

            button = InputView.restartOrEnd();
        }
    }

    private static void playBaseballGame() {
        MatchMachine matchMachine = new MatchMachine(new ComputerNumber().getNumber());
        Score score = new Score();
        while (!score.isAllStrike()) {
            score = matchMachine.compare(new BaseballNumber(InputView.inputNumber()).getNumber());
            score.printScore();
        }
    }
}
