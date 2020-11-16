import domain.*;
import ui.InputView;
import ui.ResultView;

public class Main {
    public static void main(String[] args) {
        GameButton gameButton = GameButton.GO;

        while (!gameButton.isStop()) {
            playGame();
            gameButton = gameButton.findBy(InputView.restartOrEnd());
        }
    }

    private static void playGame() {
        ComputerNumbers computerNumbers = new ComputerNumbers();
        MatchMachine matchMachine = new MatchMachine(computerNumbers.getComputerNumbers());
        ResultGame resultGame = new ResultGame();

        while (!resultGame.isAllStrike()) {
            resultGame = matchMachine.compare(new BaseballNumbers(InputView.inputNumber()));
            ResultView.printScore(resultGame);
        }
        ResultView.endMessage();
    }
}
