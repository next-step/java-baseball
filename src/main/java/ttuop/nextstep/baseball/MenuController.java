package ttuop.nextstep.baseball;

import static ttuop.nextstep.baseball.Constants.*;

/**
 * 메뉴 제어 프로그램
 *
 * @author ttuop
 */
class MenuController {

	/**
	 * 사용자가 입력한 메뉴 번호를 처리한다. 현재 지원하는 메뉴 번호는 {@link ttuop.nextstep.baseball.Constants#NEW_GAME_MENU New Game}과
	 * {@link ttuop.nextstep.baseball.Constants#SHUTDOWN_MENU Shutdown}이다.
	 *
	 * @return 메뉴 번호가 {@link ttuop.nextstep.baseball.Constants#NEW_GAME_MENU New Game}이면 true, 아니면 false
	 */
	static boolean process() {
		UserInterface.send(REQUEST_MENU_TO_USER_MESSAGE);

		final String input = receiveMessageUntilValid();

		return NEW_GAME_MENU.equals(input);
	}

	/**
	 * 사용자가 입력한 값이 유효할 때까지 메시지를 수신한다.
	 *
	 * @return 유효한 문자열
	 */
	private static String receiveMessageUntilValid() {
		String input = UserInterface.receive();

		while (!Validator.validateMenu(input)) {
			UserInterface.send(INVALID_NUMBER_MESSAGE);
			input = UserInterface.receive();
		}

		return input;
	}

}
