package baseball.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baseball.code.DisplayCode;

public class BaseballUi {

	// 게임 화면 상태
	private DisplayCode codeStatus = DisplayCode.BASEBALL_IN_GAME;
	// 시스템 입력
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

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
	 * - 게임 종료 조건을 달성했는지 여부를 판별한다.
	 *   -- 게임 종료 조건을 달성하면 컨틴뉴 화면으로 상태를 변경한다.
	 */
	private void inGameScreen() {
		System.out.print("숫자를 입력해주세요 : ");

		// int playerInput = this.getIntegerFromSystemIn();
		boolean isWonGame = true;

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
		DisplayCode displayCodeFromSystemIn = this.getDisplayCodeFromSystemIn();
		if (displayCodeFromSystemIn != null) {
			this.codeStatus = displayCodeFromSystemIn;
		}
	}

	/**
	 * 종료 화면
	 * - 프로그램을 종료하는 메시지를 출력한다.
	 */
	private void endGameScreen() {
		System.out.println("프로그램을 종료합니다. 다음에 또 만나요.");
	}

	/**
	 * 시스템에서 입력한 숫자를 통하여 화면코드를 리턴한다.
	 * @return DisplayCode
	 */
	private DisplayCode getDisplayCodeFromSystemIn() {
		int codeFromSystemIn =  this.getIntegerFromSystemIn();
		return DisplayCode.getDisplayCode(codeFromSystemIn);
	}

	/**
	 * 시스템에서 입력된 문자열 라인을 숫자로 변환한다.
	 * @return int
	 */
	private int getIntegerFromSystemIn() {
		try {
			return Integer.parseInt(this.readLineFromSystemIn());
		} catch (NumberFormatException e) {
			System.out.println("올바른 입력이 아닙니다. 숫자로 입력해주세요.");
			return Integer.MIN_VALUE;
		}
	}

	/**
	 * 시스템에서 입력된 문자열 라인을 읽는다.
	 * - 올바른 입력이 아닌 경우 (null)을 리턴한다.
	 * @return String
	 */
	private String readLineFromSystemIn() {
		try {
			return this.bufferedReader.readLine().trim();
		} catch (IOException e) {
			System.out.println("올바른 입력이 아닙니다. 다시 입력해주세요.");
			return null;
		}
	}
}
