package baseball.util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInput extends UserOutput {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final Boolean INPUT_CORRECT = true;
	private static final Boolean INPUT_ERROR = false;

	// 유저 입력 수
	private Integer userResultInput;

	/**
	 * 유저 야구게임 3자리 입력 메서드
	 */
	public void userInputBaseballNumber() {

		do {
			printUserInputNumber();
		} while (baseballNumberCheck());
	}

	/**
	 * 유저 재시작 여부 1자리 입력 메서드
	 * @return : 재시작 여부
	 */
	public Integer userInputContinueNumber() {

		do {
			printToBeContinued();
		} while (continueNumberCheck());

		return this.userResultInput;
	}

	/**
	 * 야구게임 3자리 수 입력 체크
	 * @return : 정상 입력 여부
	 */
	private boolean baseballNumberCheck() {

		boolean result = false;

		// 유저 입력
		if (userSystemInput()) {
			result = validBassballNumber();
		}

		return !result;
	}

	/**
	 * 게임 재시작 여부 1자리 입력 체크
	 * @return : 정상 입력 여부
	 */
	private boolean continueNumberCheck() {

		boolean result = false;

		// 유저 입력
		if (userSystemInput()) {
			result = validRestartNumber();
		}

		return !result;
	}

	/**
	 * 유저 입력 메서드
	 * @return : 숫자 입력 여부 확인
	 */
	private boolean userSystemInput() {

		String inputNumber = SCANNER.nextLine();

		return isNumber(inputNumber);
	}

	/**
	 * 유저로 부터 입력 받은 변수 숫자 판단 메서드
	 * @param inputNumber : 입력받은 문자열
	 * @return : 숫자 입력 여부 확인
	 */
	private boolean isNumber(String inputNumber) {

		boolean result;

		try {
			this.userResultInput = Integer.parseInt(inputNumber);
			result = INPUT_CORRECT;
		} catch (InputMismatchException | NumberFormatException exception) {
			result = inputError();
		}

		return result;
	}

	/**
	 * 재시작 여부 입력 받은 값 체크 메서드
	 * @return : 정상 게임 재시작 입력 여부 (1 or 2)
	 */
	private boolean validRestartNumber() {

		if (this.userResultInput.equals(BASEBALL_GAME_RESTART) ||
			this.userResultInput.equals(BASEBALL_GAME_END)) {

			return INPUT_CORRECT;
		}

		return inputError();
	}

	/**
	 * 야구 게임 3자리 입력 정상 여부 체크 메서드
	 * @return : 정상 야구 게임 숫자 3자리 여부 (중복 되지 않은 3자리 수)
	 */
	private boolean validBassballNumber() {

		this.duplicateCheckSet = addBaseballSet();

		if (duplicateCheckSet.size() == BASEBALL_GAME_COUNT) {

			baseballGoalNumber = new ArrayList<>(duplicateCheckSet);
			return INPUT_CORRECT;
		}

		return inputError();
	}

	/**
	 * 입력 받은 문자 중복 제거 (중복된 숫자을 입력 시 제거)
	 * @return : 중복되지 않은 수 Set 변수
	 */
	private Set<Integer> addBaseballSet() {

		Set<Integer> set = new LinkedHashSet<>();
		String[] input = this.userResultInput.toString().split("");

		for (String s : input) {

			set.add(Integer.parseInt(s));
		}

		return set;
	}

	/**
	 * 유저 입력 에러 호출 메서드
	 * @return : false
	 */
	private boolean inputError() {
		printInputError();
		return INPUT_ERROR;
	}

}
