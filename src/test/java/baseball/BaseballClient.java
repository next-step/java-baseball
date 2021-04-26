package baseball;

import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.List;
import java.util.Map;

public class BaseballClient {
    public static void main(String[] args) {
        Referee referee = new Referee();

        int play = play(referee);
        while(play == 1) {
            referee = new Referee();
            play = play(referee);
        }
    }

    private static int play(Referee referee) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        boolean gameEnd = false;
        while(!gameEnd) {
            List<Integer> input = inputView.questionToList("숫자를입력해주세요: ");
            Map<String, Integer> playerSwing = referee.decide(input);
            gameEnd = resultView.printBaseBall(playerSwing);
        }
        String question = inputView.questionLn("게임을새로시작하려면1,종료하려면2를입력하세요.");
        return Integer.parseInt(question);
    }
}
