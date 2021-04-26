package ttuop.nextstep.baseball;

/**
 * 야구게임 심판. 사용자기 입력한 값을 정답과 비교하여 스트라이크와 볼을 판정한다.
 *
 * @author ttuop
 */
class Referee {

	private final String answer;

	Referee(final String answer) {
		this.answer = answer;
	}

	/**
	 * 스트라이크를 개수를 반환한다.
	 *
	 * @param str 비교할 문자열
	 * @return 유효하지 않은 문자열이면 -1, 그렇지 않으면 2개의 문자열에 동일한 문자의 위치가 같은 개수
	 */
	int findStrike(final String str) {
		if (!Validator.validateQuestion(str)) {
			return -1;
		}

		return getStrikePoint(str);
	}

	/**
	 * 같은 위치에 문자가 같은 경우의 수를 반환한다.
	 *
	 * @param str 비교할 문자열
	 * @return 같은 위치에 값이 같은 문자 개수
	 */
	private int getStrikePoint(final String str) {
		int point = 0;

		for (int i = 0; i < answer.length(); i++) {
			point += getPoint(isEqualCharacter(answer.charAt(i), str.charAt(i)));
		}

		return point;
	}

	/**
	 * 두 문자가 같은지 확인한다.
	 *
	 * @param char1 비교 대상 1
	 * @param char2 비교 대상 2
	 * @return 두 문자가 같으면 true, 아니면 false
	 */
	private boolean isEqualCharacter(final char char1, final char char2) {
		return char1 == char2;
	}

	/**
	 * 조건에 맞는 포인트를 반환한다.
	 *
	 * @param condition 포인트 부여 조건
	 * @return 조건이 참이면 1, 아니면 0
	 */
	private int getPoint(final boolean condition) {
		if (condition) {
			return 1;
		}

		return 0;
	}

	/**
	 * 볼 개수를 반환한다.
	 *
	 * @param str 비교할 문자열
	 * @return 유효하지 않은 문자열이면 -1, 그렇지 않으면 2개의 문자열에 동일한 문자가 있지만 위치가 다른 문자 개수
	 */
	int findBall(final String str) {
		if (!Validator.validateQuestion(str)) {
			return -1;
		}

		return getBallPoint(str);
	}

	/**
	 * 2개의 문자열에 같은 문자가 있지만 위치가 다른 경우의 수 반환
	 *
	 * @param str 비교할 문자열
	 * @return 2개의 문자열에 같은 문자가 있지만 위치가 다른 문자 개수
	 */
	private int getBallPoint(final String str) {
		int point = 0;

		for (int i = 0; i < str.length(); i++) {
			final int index = answer.indexOf(str.charAt(i));
			point += getPoint(isValidIndex(index, i));
		}

		return point;
	}

	/**
	 * 볼로 판정할 수 있는 유효한 인덱스인지 확인하다.
	 *
	 * @param index 정답 배열의 인덱스
	 * @param current 질문 배열의 현재 인덱스
	 * @return 정답 배열의 인덱스가 유효(index > -1)하고 정답 인덱스와 질문의 현재 인덱스가 일치하지 않으면 true, 아니면 false
	 */
	private boolean isValidIndex(final int index, final int current) {
		return index > -1 && index != current;
	}

}
