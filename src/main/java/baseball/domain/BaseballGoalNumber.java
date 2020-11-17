package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import baseball.dao.BaseballConstant;

public class BaseballGoalNumber extends BaseballConstant {

	// 랜덤 상수를 위핸 Random 객체 생성
	private static final Random random = new Random();

	/**
	 * 랜덤 상수 생성하는 생성자
	 */
	public BaseballGoalNumber() {

		this.init();
		getBaseballGoal();
	}

	private void init() {
		this.duplicateCheckSet = new HashSet<>();
		this.baseballGoalNumber = new ArrayList<>();
	}

	/**
	 * 랜덤 상수 생성하여 중복 체크 메서드
	 */
	private void getBaseballGoal() {

		while (this.duplicateCheckSet.size() < BASEBALL_GAME_COUNT) {

			Integer randomNumber = random.nextInt(BASEBALL_GAME_RANGE) + 1;

			validateBaseball(randomNumber);
		}

	}

	/**
	 * 랜덤 상수 중복 체크 - 중복이 아닐 경우 Goal List에 값을 넣는다.
	 * @param randomNumber: 생성된 랜덤 상수
	 */
	private void validateBaseball(Integer randomNumber) {

		// 중복 체크 여부
		if (this.duplicateCheckSet.add(randomNumber)) {

			this.baseballGoalNumber.add(randomNumber);
		}
	}
}

