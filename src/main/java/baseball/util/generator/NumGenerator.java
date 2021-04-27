package baseball.util.generator;

import java.util.Map;

import baseball.domain.BallNumber;

public interface NumGenerator {

	/**
	 * 중복되지 않는 숫자를 생성한다.
	 * @return Map<BallNumber, Integer>
	 */
	Map<BallNumber, Integer> generate();

}
