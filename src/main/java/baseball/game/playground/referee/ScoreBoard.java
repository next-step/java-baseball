package baseball.game.playground.referee;

import baseball.ui.UiSystem;

/**
 *  스코어보드 정보(판정 정보)와 게임 진행 정보를 관리
 */
public class ScoreBoard {

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

		String judgeDisplay = "Judge: " + board;
		uiSystem.display(judgeDisplay);

		if (gameOver) {
			uiSystem.display("게임 오버");
		}
	}
}
