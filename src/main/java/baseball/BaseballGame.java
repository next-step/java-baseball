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
	 * �߱����� �޼��� enum
	 */
	public static enum MESSAGE_CD {

		INPUT_NUM("���ڸ� �Է����ּ��� : "),

		SUCCESS("3���� ���ڸ� ��� �����̽��ϴ�! ��������"),

		NOTHING("����"),

		STRIKE("��Ʈ����ũ"),

		BALL("��"),

		MENU("���������ν����Ϸ���1,�����Ϸ���2���Է��ϼ���."),

		INPUT_NUM_ERROR("1~9�� ����3���� �Է� �����մϴ�."),

		RESTART_MENU_NUM_ERROR("1~2�� ���ڸ� �Է� �����մϴ�.");

		private final String MESSAGE;

		private MESSAGE_CD(String message) {
			this.MESSAGE = message;
		}

		public String getMessage() {
			return MESSAGE;
		}
	}

	/**
	 * �߱� ���� ����
	 */
	public void startBaseballGame() {
		// ���� ���� ����
		boolean isNewClear = true;

		// ����� �Է� ��
		int[] inputNumArr = new int[3];

		// �߱����� ��� ��
		int[] resultNumArr = new int[3];

		resultNumArr = getRandomNum();

		while (isNewClear) {
			inputNumArr = getInputNum();
			isNewClear = doCalculation(resultNumArr, inputNumArr);
		}
	}

	/**
	 * �߱����� ���� ��ȣ ����
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
	 * �߱����� ����� �Է� ��ȣ ����
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
	 * ������� ���� ����� �Է°� ��
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
	 * ���� ���� �ߺ� üũ
	 *
	 * @param checkArray
	 * @param checkIndex
	 * @return int
	 */
	public int checkDupNumArray(int[] checkArray, int checkIndex) {
		int index = checkIndex;
		for (int i = 0; i < checkIndex; i++) {
			// ���� ���� ���Ͽ� ���� �ߺ��϶� �迭 index -1
			index = index - equalToNum(checkArray[checkIndex], checkArray[i]);
		}
		return index;
	}

	/**
	 * ���� �� ���� �� 1 �ٸ� �� 0 return
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
	 * �߱����� ����� ��ȣ �Է�
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
	 * ����� �Է°��� ���� �� �� loop
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
	 * 1 �߱����� ball, strike ī��Ʈ üũ
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
	 * �߱����� ball, stirke �ʱ�ȭ
	 */
	public void resetBaseballCount() {
		ball = 0;
		strike = 0;
	}

	/**
	 * �߱����� ��� �޼��� ���
	 */
	public void printResultMessage() {
		String message = strike + " " + MESSAGE_CD.STRIKE.MESSAGE + " " + ball + " " + MESSAGE_CD.BALL.MESSAGE;
		if (strike == 0 && ball == 0) {
			message = MESSAGE_CD.NOTHING.MESSAGE;
		}
		System.out.println(message);
	}

	/**
	 * ��Ʈ����ũ �޼��� ���
	 */
	public void printStrikeMessage() {
		System.out.println(MESSAGE_CD.SUCCESS.getMessage() + "\n" + MESSAGE_CD.MENU.MESSAGE);
	}

	/**
	 * �߱����� ����� ���� 1�϶� �����, 2�϶� ���� ����
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
	 * �߱���ȣ ����� �Է� �� ��ȿ�� �˻�
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
	 * 3�ڸ��� ���ڰ� �ƴϸ鼭 �ȿ� 0�� ���� ������ IllegalArgumentException �߻�
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
	 * ����� ���Ӹ޴� �Է°� ��ȿ�� �˻�
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