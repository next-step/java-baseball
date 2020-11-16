package baseball;

import java.util.Scanner;

public class BaseballGame {

	Scanner scanner = new Scanner(System.in);
	static int ball = 0;
	static int strike = 0;

	/**
	 * �߱����� �޼��� enum
	 */
	public static enum MESSAGE_CD {

		INPUT_NUM("���ڸ� �Է����ּ��� : "),

		SUCCESS("3���� ���ڸ� ��� �����̽��ϴ�! ��������"),

		NOTHING("����"),

		STRIKE("��Ʈ����ũ"),

		BALL("��"),

		MENU("���������ν����Ϸ���1,�����Ϸ���2���Է��ϼ���.");

		final private String message;

		private MESSAGE_CD(String message) {
			this.message = message;
		}

		public String message() {
			return message;
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
		Integer intputNum = 0;
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
		System.out.print(MESSAGE_CD.INPUT_NUM.message);
		return scanner.nextInt();
	}

	/**
	 * ����� �Է°��� ���� �� �� loop
	 *
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
		String message = strike + " " + MESSAGE_CD.STRIKE.message + " " + ball + " " + MESSAGE_CD.BALL.message;
		if (strike == 0 && ball == 0) {
			message = MESSAGE_CD.NOTHING.message;
		}
		System.out.println(message);
	}

	/**
	 * ��Ʈ����ũ �޼��� ���
	 */
	public void printStrikeMessage() {
		System.out.println(MESSAGE_CD.SUCCESS.message() + "\n" + MESSAGE_CD.MENU.message);
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
		gameMenuNum = scanner.nextInt();
		if (gameMenuNum == 1) {
			startBaseballGame();
		}
		return false;
	}

	public static void main(String[] args) {
		BaseballGame baseballSet = new BaseballGame();
		baseballSet.startBaseballGame();
	}

}