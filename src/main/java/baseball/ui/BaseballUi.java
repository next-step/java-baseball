package baseball.ui;

import baseball.code.DisplayCode;
import baseball.core.BaseballCore;

public class BaseballUi {

	// 게임 화면 상태
	private DisplayCode codeStatus = DisplayCode.BASEBALL_IN_GAME;
	// 코어
	private BaseballCore baseballCore = new BaseballCore();
	// IO
	private BaseballIO baseballIO = new BaseballIO();


	/**
	 * 프로그램 진입 화면
	 * - 최초 화면은 게임 화면으로 표출한다.
	 * - 종료 상태가 아닌 경우에는 게임화면 또는 컨틴뉴 화면을 보여준다.
	 * - 종료 상태인 경우 종료 화면을 보여주고 프로그램을 종료한다.
	 */
	public void playBall() {
		while (this.codeStatus != DisplayCode.BASEBALL_END_GAME) {
			this.displayScreen();
		}
		this.endGameScreen();
	}

	/**
	 * 게임 화면과 컨틴뉴 화면 분리
	 */
	private void displayScreen() {
		if (this.codeStatus == DisplayCode.BASEBALL_CONTINUE_GAME) {
			this.continueGameScreen();
			return;
		}
		this.inGameScreen();
	}

	/**
	 * 게임 화면
	 * - 숫자 입력 요청 메시지를 출력한다.
	 */
	private void inGameScreen() {
		System.out.print("숫자를 입력해주세요 : ");

		String playerInput = baseballIO.getPlayerInput();
		if (playerInput != null) {
			this.proceedWonGame(playerInput);
		}
	}

	/**
	 * 게임 화면 내 게임 결과를 확인하고 다음 진행 상황을 체크한다.
	 * - 게임이 종료된 경우에는 게임을 초기화하는 메서드를 호출한다.
	 * - 게임 종료 조건을 달성했는지 여부를 판별한다.
	 *   -- 게임 종료 조건을 달성하면 컨틴뉴 화면으로 상태를 변경한다.
	 * @param playerInput
	 */
	private void proceedWonGame(String playerInput) {
		// 초기화
		baseballCore.resetGameWhenNewGame();
		// 종료 조건 달성 여부 판별
		boolean isWonGame = baseballCore.checkWinGame(playerInput);
		if (isWonGame) {
			this.codeStatus = DisplayCode.BASEBALL_CONTINUE_GAME;
		}
	}

	/**
	 * 컨틴뉴 화면
	 * - 프로그램 진행 여부를 묻는 메시지를 출력한다.
	 * - 전달받은 화면코드가 존재하면 화면 상태를 변경한다.
	 */
	private void continueGameScreen() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
		DisplayCode displayCodeFromSystemIn = baseballIO.getDisplayCodeFromSystemIn();
		if (displayCodeFromSystemIn != null) {
			this.codeStatus = displayCodeFromSystemIn;
		}
	}

	/**
	 * 종료 화면
	 * - 프로그램을 종료하는 메시지를 출력한다.
	 */
	private void endGameScreen() {
		baseballIO.closeIO();
		System.out.println("프로그램을 종료합니다. 다음에 또 만나요.");
	}
}
