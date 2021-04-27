package baseball.view;

import baseball.domain.GameResult;

public class ResultScreen {
    public void view(GameResult gameResult) {
        viewFinishedMessage(gameResult.isAllStrikes());
        System.out.println(gameResult);
    }

    private void viewFinishedMessage(boolean finished) {
        if (finished) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
