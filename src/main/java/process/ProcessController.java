package process;

import logic.Answer;
import logic.BaseballGameCoreLogic;
import ui.Presentator;

import java.util.ArrayList;
import java.util.List;

public class ProcessController {

    Presentator presentator;
    BaseballGameCoreLogic logic;

    public ProcessController(Presentator presentator, BaseballGameCoreLogic logic) {
        this.presentator = presentator;
        this.logic = logic;
    }

    public void runProcess() {
        boolean isWantPlayGame = true;
        while(isWantPlayGame) {
            init();
            run();
            System.out.println("end game");
        }
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
