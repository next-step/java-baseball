package process;

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

    //todo : initPhase를 생성

    public void inputPhase() {
        String inputValue = presentator.presentInputNumber();
        List<Integer> question = convertStringToAnswerFormat(inputValue);
        GameResult gameResult = logic.calculateResult(question);
    }

    private List<Integer> convertStringToAnswerFormat(String inputValue) {
        List<Integer> formattedValue = new ArrayList<>();
        for (int i=0;i<inputValue.length();i++) {
            formattedValue.add((int) inputValue.charAt(i));
        }
        return formattedValue;
    }

}
