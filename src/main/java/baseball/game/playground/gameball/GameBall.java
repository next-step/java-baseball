package baseball.game.playground.gameball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import baseball.game.playground.gameball.validatitor.InputStringValidator;

/**
 * 번호의 범위는 최소 1, 최대 9로 제한된다
 * 번호는 3개로 이루어져있다
 * 각각의 번호는 중첩되지 않는
 */
public class GameBall {

	private final String numberToString;
	private final Integer numberToInteger;

	public GameBall(GameNumber[] numbers) {

		StringBuilder numberString = new StringBuilder();
		for (GameNumber number : numbers) {
			numberString.append(number.getNum());
		}

		this.numberToString = numberString.toString();
		this.numberToInteger = Integer.parseInt(numberString.toString());
	}

	@Override
	public String toString() {
		return numberToString;
	}

	public Integer toInteger() {
		return numberToInteger;
	}

	/**
	 * 구현 정책
	 */
	public static class Policy {
		public static final int DIGIT_NUMBER = 3; // 3자리 번호
		public static final int BEGIN_RANGE = GameNumber.Policy.MIN_RANGE; // 초과 값
		public static final int END_RANGE = GameNumber.Policy.MAX_RANGE + 1; // 초과 값
	}

	// 중복되지 않는 난수 생성
	private static List<Integer> generateNonOverlapShuffleNumbers() {
		List<Integer> numList = new ArrayList<>();
		for (int i = Policy.BEGIN_RANGE; i < Policy.END_RANGE; i++) {
			numList.add(i);
		}
		Collections.shuffle(numList);
		return numList;
	}

	// 3개의 번호를 가져온다
	private static GameNumber[] getThreeBallNumbers(List<Integer> numList) {

		GameNumber[] numbers = new GameNumber[Policy.DIGIT_NUMBER];
		for (int i = 0; i < Policy.DIGIT_NUMBER; i++) {
			numbers[i] = GameNumber.create(numList.get(i));
		}
		return numbers;
	}

	////////////////////////////////////////////////////////////////////////////////////
	// GameBall 데이터 생성
	////////////////////////////////////////////////////////////////////////////////////
	// 게임에 사용할 볼 정보를 생성한다 - 랜덤 생성
	public static GameBall create() {

		List<Integer> numList = generateNonOverlapShuffleNumbers();
		GameNumber[] numbers = getThreeBallNumbers(numList);
		return new GameBall(numbers);

	}

	// 정수형으로 생성
	public static GameBall create(Integer number) {

		String stringNumber = String.valueOf(number);
		InputStringValidator.check(stringNumber);
		GameNumber[] numbers = createBallNumbers(stringNumber);
		return new GameBall(numbers);

	}

	// 문자열로 생성
	public static GameBall create(String string) {

		InputStringValidator.check(string);
		GameNumber[] numbers = createBallNumbers(string);
		return new GameBall(numbers);
	}

	// 볼 번호 생성
	private static GameNumber[] createBallNumbers(String inputString) {

		GameNumber[] numbers = new GameNumber[Policy.DIGIT_NUMBER];
		for (int i = 0; i < inputString.length(); i++) {
			numbers[i] = GameNumber.create(inputString.charAt(i));
		}
		return numbers;
	}
}
