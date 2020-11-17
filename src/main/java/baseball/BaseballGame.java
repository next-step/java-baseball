package baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseballGame {

	Scanner scanner = new Scanner(System.in);

	static int ball = 0;
	static int strike = 0;

	public int getBall() {
	        return ball;
	}

	public int getStrike() {
        return strike;
	}

	public final int RESTART_GAME = 1;
	public final int EXIT_GAME = 2;


	/**
	 * 야구게임 메세지 enum
	 */
	public static enum MESSAGE_CD {

		INPUT_NUM("숫자를 입력해주세요 : "),

		SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임종료"),

		NOTHING("낫싱"),

		STRIKE("스트라이크"),

		BALL("볼"),

		MENU("게임을새로시작하려면1,종료하려면2를입력하세요."),

		INPUT_NUM_ERROR("1~9인 숫자3개만 입력 가능합니다."),

		RESTART_MENU_NUM_ERROR("1~2인 숫자만 입력 가능합니다.");

		private final String MESSAGE;

		private MESSAGE_CD(String message) {
			this.MESSAGE = message;
		}

		public String getMessage() {
			return MESSAGE;
		}
	}

	/**
	 * 야구 게임 시작
	 */
	public void startBaseballGame() {
		// 게임 시작 여부
		boolean isNewClear = true;

		// 사용자 입력 값
		int[] inputNumArr = new int[3];

		// 야구게임 결과 값
		int[] resultNumArr = new int[3];

		resultNumArr = getRandomNum();

		while (isNewClear) {
			inputNumArr = getInputNum();
			isNewClear = doCalculation(resultNumArr, inputNumArr);
		}
	}

	/**
	 * 야구게임 랜덤 번호 추출
	 *
	 * @return int[]
	 */
	public int[] getRandomNum() {
		int[] randomArray = new int[3];

		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = (int) (Math.random() * 9) + 1;
			i = checkDupNumArray(randomArray, i);
		}
		return randomArray;
	}

	/**
	 * 야구게임 사용자 입력 번호 추출
	 *
	 * @return int[]
	 */
	public int[] getInputNum() {
		int intputNum = 0;
		int[] inputNumArray = new int[3];
		intputNum = setInputNum();
		for (int i = 0; i < 3; i++) {
			int endIndex = i + 1;
			inputNumArray[i] = Integer.parseInt(Integer.toString(intputNum).substring(i, endIndex));
		}

		return inputNumArray;
	}

	/**
	 * 랜덤결과 값과 사용자 입력값 비교
	 *
	 * @param resultArr
	 * @param inputNumArr
	 * @return
	 */
	public boolean doCalculation(int[] resultNumArr, int[] inputNumArr) {
		boolean gameResult = true;
		for (int i = 0; i < resultNumArr.length; i++) {
			loopToInputArrRsltArr(inputNumArr, resultNumArr[i], i);
		}
		printResultMessage();
		if (strike == 3) {
			gameResult = restartGameMenu();
		}
		resetBaseballCount();
		return gameResult;
	}

	/**
	 * 랜덤 숫자 중복 체크
	 *
	 * @param checkArray
	 * @param checkIndex
	 * @return int
	 */
	public int checkDupNumArray(int[] checkArray, int checkIndex) {
		int index = checkIndex;
		for (int i = 0; i < checkIndex; i++) {
			// 이전 값과 비교하여 값이 중복일때 배열 index -1
			index = index - equalToNum(checkArray[checkIndex], checkArray[i]);
		}
		return index;
	}

	/**
	 * 숫자 비교 같을 때 1 다를 때 0 return
	 *
	 * @param checkNum
	 * @param inputNum
	 * @return int
	 */
	public int equalToNum(int checkNum, int inputNum) {
		int result = 0;

		if (checkNum == inputNum) {
			result = 1;
			return result;
		}
		return result;
	}

	/**
	 * 야구게임 사용자 번호 입력
	 *
	 * @return int
	 */
	public int setInputNum() {
		int inputNum = 0;
		while (true) {
			try {
				System.out.print(MESSAGE_CD.INPUT_NUM.MESSAGE);
				inputNum = scanner.nextInt();
				validCheckBaseballInputNum(inputNum);
				break;
			} catch (InputMismatchException e) {
				scanner = new Scanner(System.in);
			} catch (IllegalArgumentException e) {
				System.out.println(MESSAGE_CD.INPUT_NUM_ERROR.MESSAGE);
			}
		}
		return inputNum;
	}

	/**
	 * 사용자 입력값과 랜덤 값 비교 loop
	 * @param inputNumArr
	 * @param resultNum
	 * @param resultIndex
	 */
	public void loopToInputArrRsltArr(int[] inputNumArr, int resultNum, int resultIndex) {
		int intputIndex = 0;
		for (int inputNum : inputNumArr) {
			checkBaseballCount(inputNum, resultNum, intputIndex, resultIndex);
			intputIndex++;
		}
	}

	/**
	 * 1 야구게임 ball, strike 카운트 체크
	 *
	 * @param inputNum
	 * @param resultNum
	 * @param resultIndex
	 * @param intputIndex
	 */
	public void checkBaseballCount(int inputNum, int resultNum, int intputIndex, int resultIndex) {
		if (inputNum == resultNum && intputIndex == resultIndex) {
			strike++;
		}
		if (inputNum == resultNum && intputIndex != resultIndex) {
			ball++;
		}
	}

	/**
	 * 야구게임 ball, stirke 초기화
	 */
	public void resetBaseballCount() {
		ball = 0;
		strike = 0;
	}

	/**
	 * 야구게임 결과 메세지 출력
	 */
	public void printResultMessage() {
		String message = strike + " " + MESSAGE_CD.STRIKE.MESSAGE + " " + ball + " " + MESSAGE_CD.BALL.MESSAGE;
		if (strike == 0 && ball == 0) {
			message = MESSAGE_CD.NOTHING.MESSAGE;
		}
		System.out.println(message);
	}

	/**
	 * 스트라이크 메세지 출력
	 */
	public void printStrikeMessage() {
		System.out.println(MESSAGE_CD.SUCCESS.getMessage() + "\n" + MESSAGE_CD.MENU.MESSAGE);
	}

	/**
	 * 야구게임 재시작 여부 1일때 재시작, 2일때 게임 종료
	 *
	 * @return boolean
	 */
	public boolean restartGameMenu() {
		int gameMenuNum = 0;
		resetBaseballCount();
		printStrikeMessage();
		while (true) {
			try {
				gameMenuNum = scanner.nextInt();
				validCheckRestartMenuNum(gameMenuNum);
				break;
			} catch (InputMismatchException e) {
				System.out.println(MESSAGE_CD.RESTART_MENU_NUM_ERROR.MESSAGE);
				scanner = new Scanner(System.in);
			} catch (IllegalArgumentException e) {
				System.out.println(MESSAGE_CD.RESTART_MENU_NUM_ERROR.MESSAGE);
			}
		}
		return false;
	}

	/**
	 * 야구번호 사용자 입력 값 유효성 검사
	 * @param num
	 */
	public void validCheckBaseballInputNum(int inputNum) {
		int lengthCheck = 3;
		int zeroCheck = inputNum;
		lengthCheck = (int) (Math.log10(inputNum) + 1);
		checkInputExecption(zeroCheck, lengthCheck);
		while (zeroCheck > 0) {
			checkInputExecption(zeroCheck, lengthCheck);
			zeroCheck /= 10;
		}
	}

	/**
	 * 3자리의 숫자가 아니면서 안에 0의 값이 있을시 IllegalArgumentException 발생
	 *
	 * @param zeroCheck
	 * @param lengthCheck
	 */
	public void checkInputExecption(int zeroCheck, int lengthCheck) {
		if (zeroCheck % 10 == 0 || lengthCheck != 3) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * 재시작 게임메뉴 입력값 유효성 검사
	 */
	public void validCheckRestartMenuNum(int restartMenuNum){
		if (restartMenuNum != RESTART_GAME && restartMenuNum != EXIT_GAME) {
			throw new IllegalArgumentException();
		}
		if(restartMenuNum == RESTART_GAME){
			startBaseballGame();
		}
	}

	public static void main(String[] args) {
		BaseballGame baseballSet = new BaseballGame();
		baseballSet.startBaseballGame();
	}

}