package process;

import logic.Answer;
import logic.BaseballGameCoreLogic;
import ui.Presentator;

import java.util.List;

public class ProcessController {

    Presentator presentator;
    BaseballGameCoreLogic logic;

    public ProcessController(Presentator presentator, BaseballGameCoreLogic logic) {
        this.presentator = presentator;
        this.logic = logic;
    }

    public void runProcess() throws Exception {
        boolean isWantPlayGame = true;
        while(isWantPlayGame) {
            init();
            run();
            isWantPlayGame = endGame();
        }
    }

    private boolean endGame() throws Exception {
        String inputValue = presentator.endGame();
        if (inputValue.equals(Presentator.RESTART)) return true;
        if (inputValue.equals(Presentator.QUIT)) return false;
        throw new Exception("잘못된 접근입니다.");
    }

    private void init() {
        logic.generateAnswer();
    }

    public void run() {
        boolean isEndGame = false;
        while(!isEndGame) {
            List<Integer> question = inputPhase();
            isEndGame = showResultPhase(question);
        }
    }

    public List<Integer> inputPhase() {
        String inputValue = presentator.presentInputNumber();
        List<Integer> question = Answer.convertStringToAnswerFormat(inputValue);
        return question;
    }

    private boolean showResultPhase(List<Integer> question) {
        GameResult gameResult = logic.calculateResult(question);
        presentator.displayResult(gameResult);
        return gameResult.isGameEnd();
    }


}
