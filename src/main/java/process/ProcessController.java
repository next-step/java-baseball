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
        String inputValue = getRestartOrQuitFromUI();
        if (inputValue.equals(Presentator.RESTART)) return true;
        if (inputValue.equals(Presentator.QUIT)) return false;
        throw new Exception("잘못된 접근입니다.");
    }

    private String getRestartOrQuitFromUI() throws Exception {
        String inputValue;
        boolean isValid;
        do {
            inputValue = presentator.endGame();
            isValid = validationProcess(Validator.Type.END_GAME, inputValue);
        } while (!isValid);
        return inputValue;
    }

    private boolean validationProcess(Validator.Type type, Object inputValue) throws Exception {
        boolean isValid = Validator.isValid(type, inputValue);
        if(!isValid) {
            presentator.displayInputError();
        }
        return isValid;
    }

    private void init() {
        logic.generateAnswer();
    }

    public void run() throws Exception {
        boolean isEndGame = false;
        while(!isEndGame) {
            List<Integer> question = inputPhase();
            isEndGame = showResultPhase(question);
        }
    }

    public List<Integer> inputPhase() throws Exception {
        String inputValue = getValidInputNumberFromUI();
        return Answer.convertStringToAnswerFormat(inputValue);
    }

    private String getValidInputNumberFromUI() throws Exception {
        boolean isValid;
        String inputValue;
        do {
            inputValue = presentator.presentInputNumber();
            isValid = validationProcess(Validator.Type.INPUT_NUMBER, inputValue);
        } while (!isValid);
        return inputValue;
    }

    private boolean showResultPhase(List<Integer> question) {
        GameResult gameResult = logic.calculateResult(question);
        presentator.displayResult(gameResult);
        return gameResult.isGameEnd();
    }
}
