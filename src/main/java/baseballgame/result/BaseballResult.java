package baseballgame.result;

import baseballgame.number.BaseballNumber;
import lombok.Getter;

import java.util.List;

import static baseballgame.io.Messages.*;

@Getter
public class BaseballResult {

    private int ballCount = 0;
    private int strikeCount = 0;
    private String message = "";

    private final BaseballNumber inputNumber;
    private final BaseballNumber answerNumber;

    public BaseballResult(BaseballNumber inputNumber, BaseballNumber answerNumber) {
        this.inputNumber = inputNumber;
        this.answerNumber = answerNumber;
        updateCount();
        updateResultMessage();
    }

    private void updateCount() {
        List<String> input = inputNumber.getNumber();
        List<String> answer = answerNumber.getNumber();

        for (int i = 0; i < input.size(); i++) {
            addStrikeCount(input.get(i), answer.get(i));
            addBallCount(input.get(i), answer);
        }
        this.ballCount -= this.strikeCount;
    }

    private void updateResultMessage() {
        if (strikeCount > 0) {
            message += strikeCount + STRIKE.getMessage();
        }
        if (ballCount > 0) {
            message += ballCount + BALL.getMessage();
        }
        if (strikeCount == 0 && ballCount == 0) {
            message += NOTHING.getMessage();
        }
    }

    private void addStrikeCount(String input, String answer){
        if(input.equals(answer)) {
            this.strikeCount++;
        }
    }

    private void addBallCount(String input, List<String> answer){
        if(answer.contains(input)) {
            this.ballCount++;
        }
    }

    public boolean isClear() {
        return this.strikeCount == 3;
    }

}
