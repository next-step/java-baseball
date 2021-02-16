package game.view;

import game.domain.Unit;

public class ResultView {

    private static final String THREE_STRIKE = "3스트라이크\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ERROR_ANSWER = "1과 2가 아닌 값이 들어왔습니다. 다시 입력해주세요.";
    private static final String ERROR_BASEBALL_NUM = "각 숫자는 3자리수이며 서로 다른 값이어야 합니다.";
    public void printResult(long strikeCount, long ballCount) {
        System.out.println(getResult(strikeCount, ballCount));
    }
    private StringBuilder getResult(long strikeCount, long ballCount) {
        StringBuilder stringBuilder = new StringBuilder();
        if (strikeCount == 3) {
            return stringBuilder.append(THREE_STRIKE);
        }
        if (ballCount > 0) {
            stringBuilder.append(ballCount).append(Unit.BALL.getUnit());
        }
        if (strikeCount > 0) {
            stringBuilder.append(strikeCount).append(Unit.STRIKE.getUnit());
        }
        return stringBuilder;
    }

    public void printErrorAnswer() {
        System.out.println(ERROR_ANSWER);
    }

    public void printErrorBaseballNum() {
        System.out.println(ERROR_BASEBALL_NUM);
    }
}
