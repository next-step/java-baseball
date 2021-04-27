package game.baseball.answer;

import game.baseball.constant.BaseballResult;
import game.baseball.vo.Answer;
import game.baseball.vo.CheckResult;

import java.util.List;

import static game.baseball.constant.BaseballConfig.ANSWER_COUNT;

public class AnswerChecker {
    private AnswerChecker(){
        throw new IllegalStateException("Checker Class");
    }

    public static boolean checkAnswer(Answer answer, List<Integer> inputNumberList) {
        if (inputNumberList == null || inputNumberList.size() != ANSWER_COUNT) {
            System.out.println("확인할 사용자의 데이터가 잘못되었습니다.");
            return false;
        }

        CheckResult checkResult = new CheckResult();

        for (int index = 0; index < ANSWER_COUNT; index++) {
            checkResult.addResult(checkEachNumber(answer, index, inputNumberList.get(index)));
        }

        System.out.println(checkResult.getResultString());

        return checkResult.isGameFinish();
    }

    private static BaseballResult checkEachNumber(Answer answer, int index, Integer num) {
        int answerIndex = answer.getIndexOfNumberInAnswer(num);

        if (answerIndex == index) {
            return BaseballResult.STRIKE;
        }

        if (answerIndex != -1) {
            return BaseballResult.BALL;
        }

        return BaseballResult.NONE;
    }
}
