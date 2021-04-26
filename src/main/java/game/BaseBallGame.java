package game;

import common.CommonUtil;
import common.ConstantUtil;

public class BaseBallGame {
    private Referee referee;

    public Referee getReferee() {
        return referee;
    }

    public void startGame() {
        startGame(new Hitter());
    }

    private void startGame(Hitter hitter) {
        this.referee = new Referee();
        GameResult gameResult;

        do {
            gameResult = getReferee().getGameResult(new Pitcher(), hitter);
            gameResult.printGameResult();
        } while (!gameResult.isCorrect());

        reStartGame();
    }

    private void reStartGame() {
        if (isReStartGame(getInputIsReStart())) {
            startGame();
        }
    }

    private String getInputIsReStart() {
        return CommonUtil.scannerNextMessageAndPattern("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", ConstantUtil.INPUT_RESTART_PATTERN);
    }

    private boolean isReStartGame(String input) {
        return input.equals("1");
    }
}
