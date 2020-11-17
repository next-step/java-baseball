package baseball;

import java.util.List;
import java.util.Random;

public class BaseballGame {

    private final BaseballDigitGenerator baseballDigitGenerator;
    private final BaseballJudge baseballJudge;

    public BaseballGame(BaseballDigitGenerator baseballDigitGenerator, BaseballJudge baseballJudge) {
        this.baseballDigitGenerator = baseballDigitGenerator;
        this.baseballJudge = baseballJudge;
    }

    public void play() {
        List<String> answer = this.baseballDigitGenerator.generateRandomDigits(new Random());
        BaseballResult result;
        do {
            List<String> input = baseballDigitGenerator.generateDigitsByUserInput();
            result = baseballJudge.createBaseBallResult(answer, input);
            System.out.println(result.getJudgementMessage());
        } while (!result.isRightAnswer());
    }
}
