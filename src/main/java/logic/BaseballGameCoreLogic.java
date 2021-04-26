package logic;

import java.util.List;

public class BaseballGameCoreLogic {

    private Answer answer;

    public void generateAnswer() {
        answer = new Answer();
    }

    public List<Integer> getAnswer() {
        return answer.getAnswer();
    }
}
