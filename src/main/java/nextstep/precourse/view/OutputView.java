package nextstep.precourse.view;

import nextstep.precourse.ViewUtils;
import nextstep.precourse.domain.GameResult;

public class OutputView {
    private static final String STRIKE_MESSAGE = "스트라이크 ";
    private static final String BALL_MESSAGE = "볼";
    private static final String FOUR_BALL_MESSAGE = "포볼";
    private static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void showResult(GameResult gameResult) {
        if(!gameResult.isZeroStrike()) {
            ViewUtils.printLine(gameResult.getStrike() + STRIKE_MESSAGE);
        }
        if(!gameResult.isZeroBall()) {
            ViewUtils.printLine(gameResult.getBall() + BALL_MESSAGE);
        }
        if(gameResult.isFourBall()) {
            ViewUtils.printLine(FOUR_BALL_MESSAGE);
        }
    }

    public void showCorrectMessage() {
        ViewUtils.printLine(CORRECT_MESSAGE);
    }
}
