package baseball.game.scoreBoard;

import baseball.ui.UiSystem;

/**
 * 스코어보드 정보(판정 정보)와 게임 진행 정보를 관리
 */
public class ScoreBoard {

    private static final String FINALLY_COMMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final String board;

    private final boolean gameOver;

    public ScoreBoard(String board, boolean gameOver) {
        this.board = board;
        this.gameOver = gameOver;
    }

    public String getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    // UI 시스템에 스코어링 결과를 출력한다
    public void display(UiSystem uiSystem) {

        String judgeDisplay = "[Judge]\n" + "\t" + board;
        uiSystem.display(judgeDisplay);

        if (gameOver) {
            uiSystem.display(FINALLY_COMMENT);
        }
    }
}
