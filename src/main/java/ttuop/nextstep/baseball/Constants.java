package ttuop.nextstep.baseball;

import java.util.Arrays;
import java.util.List;

/**
 * 야구게임 상수 클래스
 *
 * @author ttuop
 */
final class Constants {

	static final int ANSWER_DIGIT = 3;
	static final String REGEX_OF_ANSWER = "^(?!.*(.).*\\1)[1-9]{3}$";

	static final List<Character> LIST_OF_ANSWER_ELEMENTS = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');

	static final String STRIKE = "스트라이크";
	static final String BALL = "볼";

	static final String THREE_STRIKE_MESSAGE = "3 스트라이크. 3개의 숫자를 모두 맞혔습니다! 게임 종료.";
	static final String INVALID_NUMBER_MESSAGE = "숫자를 잘못 입력하였습니다. 다시 입력해주세요.";
	static final String NOTHING_MESSAGE = "낫싱. 일치하는 숫자가 없습니다.";

	static final String REQUEST_NUMBER_TO_USER_MESSAGE = "숫자를 입력해주세요 : ";
	static final String REQUEST_MENU_TO_USER_MESSAGE = "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.";

	static final String NEW_GAME_MENU = "1";
	static final String SHUTDOWN_MENU = "2";
}
