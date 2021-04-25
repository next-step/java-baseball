package ttuop.nextstep.baseball;

import static ttuop.nextstep.baseball.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 야구 게임에 필요한 정답 생성자
 *
 * @author ttoup
 */
class AnswerGenerator {

	/**
	 * 야구게임 정답을 생성한다.
	 *
	 * @return {@link ttuop.nextstep.baseball.Constants#LIST_OF_ANSWER_ELEMENTS LIST_OF_ANSWER_ELEMENTS} 에서
	 *     중복되지 않는 요소를 {@link ttuop.nextstep.baseball.Constants#ANSWER_DIGIT Answer Digit} 만큼 추출하여 문자열을 생성
	 */
	String generate() {
		final List<Character> numbers = new ArrayList<>(LIST_OF_ANSWER_ELEMENTS);
		final Random random = new Random();
		final StringBuilder builder = new StringBuilder();

		int size = numbers.size();
		for (int i = 0; i < ANSWER_DIGIT; i++) {
			builder.append(numbers.remove(random.nextInt(--size)));
		}

		return builder.toString();
	}

}
