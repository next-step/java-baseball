package ttuop.nextstep.baseball;

import static ttuop.nextstep.baseball.Constants.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 심판 판정을 사용자에게 보여줄 메시지로 변환한다.
 *
 * @author ttuop
 */
class RefereeCallResolver {

	private static final Map<Integer, String> MESSAGE_MAP = new HashMap<>();

	static {
		MESSAGE_MAP.put(30, THREE_STRIKE_MESSAGE);
		MESSAGE_MAP.put(-11, INVALID_NUMBER_MESSAGE);
		MESSAGE_MAP.put(0, NOTHING_MESSAGE);
	}

	/**
	 * 스트라이크와 볼 판정에 맞는 메시지를 반환하다. {@link #MESSAGE_MAP}에 등록된 메시지를 찾아보고
	 * 없으면 판정에 맞는 메시지를 생성해서 반환한다.
	 *
	 * @param strike 스트라이크 판정
	 * @param ball 볼 판정
	 * @return {@link #MESSAGE_MAP}에 등록된 키가 있으면 해당 메시지를 반환하고, 아니면 메시지를 새로 생성
	 */
	static String getMessage(final int strike, final int ball) {
		return MESSAGE_MAP.getOrDefault(getKey(strike, ball), makeMessage(strike, ball));
	}

	/**
	 * {@link #MESSAGE_MAP}을 조회하기 위한 키를 생성한다.
	 *
	 * @param strike 스트라이크 판정
	 * @param ball 볼 판정
	 * @return 키
	 */
	private static int getKey(final int strike, final int ball) {
		return strike * 10 + ball;
	}

	/**
	 * 스트라이크와 볼 판정에 맞는 메시지를 새로 생성한다.
	 *
	 * @param strike 스트라이크 판정
	 * @param ball 볼 판정
	 * @return 스트라이크 판정 메시지에 볼 판정 메시지를 붙여서 새로운 메시지 생성
	 */
	private static String makeMessage(final int strike, final int ball) {
		return concat(concat(strike, STRIKE), concat(ball, BALL));
	}

	/**
	 * 문자열 2개를 붙여서 새로운 문자열을 생성한다.
	 *
	 * @param str1 문자열 1
	 * @param str2 문자열 2
	 * @return 두 문자열 중에 길이가 0인 게 있으면 문자열을 그대로 붙이고, 아니면 문자열 사이에 스페이스를 삽입한다.
	 */
	private static String concat(final String str1, final String str2) {
		if (str1.length() == 0 || str2.length() == 0) {
			return str1 + str2;
		}

		return str1 + " " + str2;
	}

	/**
	 * 숫자와 문자열을 붙여서 새로운 문자열을 생성한다.
	 *
	 * @param num 숫자
	 * @param str 문자열
	 * @return 숫자의 값이 0이면 빈문자열을 반환하고, 아니면 숫자와 문자열 사이에 스페이스를 삽입한다.
	 */
	private static String concat(final int num, final String str) {
		if (num == 0) {
			return "";
		}

		return num + " " + str;
	}

}
