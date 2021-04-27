package logic;

import process.GameResult;

import java.util.List;

public class BaseballGameCoreLogic {

    private Answer answer;

    public void generateAnswer() {
        answer = new Answer();
    }

    public List<Integer> getAnswer() {
        return answer.getAnswer();
    }

    public GameResult calculateResult(List<Integer> question) {
        return answer.calculateResult(question);
    }

}
