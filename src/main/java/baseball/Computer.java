package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answer = new ArrayList<>();
    private int answerCount;

    public Computer() {
        this.createAnswer();
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void createAnswer() {
        this.answer.clear();
        for (int i = 0; i < Constants.ANSWER_SIZE; i++) {
            this.answer.add(getNotExistNum());
        }
    }

    private int getNotExistNum() {
        int answerNum = getOneToNineRandomNum();
        for (this.answerCount = 0; answerCount < this.answer.size(); answerCount++) {
            answerNum = resetAnswerCount(answerNum);
        }
        return answerNum;
    }

    private int resetAnswerCount(int answerNum) {
        if (this.answer.get(answerCount).equals(answerNum)) {
            answerCount = -1;
            answerNum = getOneToNineRandomNum();
        }
        return answerNum;
    }

    private int getOneToNineRandomNum() {
        return (int)(Math.random() * 9) + 1;
    }
}
