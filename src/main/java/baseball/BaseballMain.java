package baseball;

import baseball.domain.Baseball;
import baseball.domain.BaseballGenerator;
import baseball.domain.Result;
import baseball.view.BaseballInputView;
import baseball.view.BaseballResultView;

public class BaseballMain {
    public static void main(String[] args) {
        do {
            Baseball answerBaseball = BaseballGenerator.generateRandomNo();
            play(answerBaseball);
        } while(BaseballInputView.playAgain());

    }

    public static void play(Baseball answer) {
        boolean isAnswer;
        do {
            Baseball userBaseball = BaseballInputView.userInputValue();
            Result result = answer.match(userBaseball);
            isAnswer = BaseballResultView.showResult(result);
        } while (!isAnswer);



    }
}
