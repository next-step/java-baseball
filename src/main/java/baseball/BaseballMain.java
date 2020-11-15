package baseball;

import baseball.domain.Baseball;
import baseball.domain.BaseballGenerator;
import baseball.domain.Result;
import baseball.view.BaseballInputView;
import baseball.view.BaseballResultView;

public class BaseballMain {
    public static void main(String[] args) {
        boolean continuePlay = true;
        while (continuePlay) {
            Baseball answerBaseball = BaseballGenerator.generateRandomNo();
            continuePlay = play(answerBaseball);
        }

    }

    public static boolean play(Baseball answer) {
        boolean isAnswer = false;
        while (!isAnswer) {
            Baseball userBaseball = BaseballInputView.userInputValue();
            Result result = answer.match(userBaseball);
            isAnswer = BaseballResultView.showResult(result);
        }
        return BaseballInputView.playAgain();


    }
}
