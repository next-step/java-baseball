import domain.BaseballGameInfo;
import domain.BaseballNumberGenerator;
import domain.ResultMessage;
import view.InputView;

import java.util.List;

public class BaseballMain {

    public static void main(String[] args) {
        do {
            List<Integer> targetBaseballNumbers = tergetBaseballNumberGenerator();
            startBaseballGame(targetBaseballNumbers);
        } while(isNewGame());
    }
    private static boolean isNewGame() {
        final int NEW_GAME = 1;
        final int QUIT = 2;

        int userIntent = InputView.getNewGameOrQuitNumber();
        if(userIntent != NEW_GAME && userIntent != QUIT) {
            throw new IllegalArgumentException("입력 오류");
        }
        return userIntent == NEW_GAME;
    }

    private static void startBaseballGame(List<Integer> targetBaseballNumbers) {
        List<Integer> userBaseballNumbers = userBaseballNumberGenerator();

        BaseballGameInfo baseballGame = new BaseballGameInfo(userBaseballNumbers, targetBaseballNumbers);
        if(!baseballGame.getIsWinning()) {
            printResult(baseballGame);
            startBaseballGame(targetBaseballNumbers);
            return;
        }
        ResultMessage.printWinningMessage();
    }

    private static List<Integer> tergetBaseballNumberGenerator() {
        return BaseballNumberGenerator.generateBaseballNumbers();
    }

    private static List<Integer> userBaseballNumberGenerator() {
        return InputView.inputNumbers();
    }

    private static void printResult(BaseballGameInfo baseballGame) {
        ResultMessage.printResult(baseballGame.getStrikeCount(), baseballGame.getBallCount());
    }
}
