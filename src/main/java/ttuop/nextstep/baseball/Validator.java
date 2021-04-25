package ttuop.nextstep.baseball;

import static ttuop.nextstep.baseball.Constants.*;

import java.util.regex.Pattern;

/**
 * 사용자가 입력한 문자열의 유효성을 체크하는 클래스
 *
 * @author ttuop
 */
class Validator {

	private static final Pattern PATTERN = Pattern.compile(REGEX_OF_ANSWER);

	/**
	 * 사용자가 입력한 메뉴 문자열의 유효성을 체크한다.
	 *
	 * @param str 체크할 문자열
	 * @return {@link ttuop.nextstep.baseball.Constants#NEW_GAME_MENU} 또는
	 * {@link ttuop.nextstep.baseball.Constants#SHUTDOWN_MENU} 중에 하나라면 true, 아니면 false 를 반환한다.
	 */
	static boolean validateMenu(final String str) {
		return NEW_GAME_MENU.equals(str) || SHUTDOWN_MENU.equals(str);
	}

	/**
	 * 사용자가 게임 질문으로 입력한 문자열의 유효성을 체크한다.
	 *
	 * @param str 체크할 문자열
	 * @return 유효한 문자열이면 true, 아니면 false 를 반환한다.
	 */
	static boolean validateQuestion(final String str) {
		return str != null && PATTERN.matcher(str).matches();
	}

}
