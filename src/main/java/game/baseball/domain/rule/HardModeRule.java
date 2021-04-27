package game.baseball.domain.rule;

import game.baseball.domain.Answer;
import game.baseball.domain.Ball;
import game.baseball.domain.Result;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HardModeRule extends BaseballGameRule {

    public HardModeRule() {
        this.initRule();
    }

    private void initRule() {
        totalBallCount = 5;
        startBallNumber = '1';
        endBallNumber = '9';
    }

    @Override
    public boolean isValidInput(String input) {
        if (!(isCorrectInputLength(input)
                && isDigitInput(input)
                && isNotDuplicatedInput(input))) {
            return false;
        }

        return true;
    }

    @Override
    public Answer generateAnswers() {
        return Answer.init(totalBallCount, startBallNumber, endBallNumber);
    }

    @Override
    public boolean isSuccess(Result result) {
        return this.isOut(result);
    }

    @Override
    public boolean isStrike(Ball ball, List<Integer> answers) {
        return answers.get(ball.getPosition()).equals(ball.getValue());
    }

    @Override
    public boolean isBall(Ball ball, List<Integer> answers) {
        return answers.contains(ball.getValue())
                && !answers.get(ball.getPosition()).equals(ball.getValue());
    }

    @Override
    public boolean isOut(Result result) {
        return result.getStrikeCount() == this.totalBallCount;
    }

    @Override
    public void printSuccessMsg() {
        System.out.println(this.totalBallCount + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isNotDuplicatedInput(String input) {
        Set<Character> inputSet = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            inputSet.add(input.charAt(i));
        }

        if (inputSet.size() != input.length()) {
            System.out.println("[입력오류] 중복된 입력값이 존재합니다. 서로 다른 숫자를 입력해주세요.");
            return false;
        }

        return true;
    }

    private boolean isCorrectInputLength(String input) {
        if (input.length() != totalBallCount) {
            System.out.println("[입력오류] 입력한 값의 길이가 틀렸습니다. " + totalBallCount + "자리 숫자를 입력해주세요.");
            return false;
        }

        return true;
    }

    private boolean isDigitInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!isNumber(input.charAt(i))) {
                System.out.println("[입력오류] 1~9 사이의 숫자를 입력해 주세요.");
                return false;
            }
        }
        return true;
    }

    private boolean isNumber(char inputChar) {
        if (startBallNumber <= inputChar && inputChar <= endBallNumber) {
            return true;
        }

        return false;
    }

    public boolean isNothing(Result result) {
        return result.getStrikeCount() == 0 && result.getBallCount() == 0;
    }
}
