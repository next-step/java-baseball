package baseball;

import java.util.Scanner;

public class BaseballGame {

	Scanner scanner = new Scanner(System.in);

	/**
	 * �߱����� �޼��� enum
	 */
	public static enum MESSAGE_CD {

		INPUT_NUM("���ڸ� �Է����ּ��� : ");

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
			i = dupCheckNumArray(randomArray, i);
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

		return gameResult;
	}

	/**
	 * ���� ���� �ߺ� üũ
	 *
	 * @param checkArray
	 * @param checkIndex
	 * @return int
	 */
	public int dupCheckNumArray(int[] checkArray, int checkIndex) {
		int index = checkIndex;
		for (int i = 0; i < checkIndex; i++) {
			// ���� ���� ���Ͽ� ���� �ߺ��϶� ���� �迭 index -1
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

	public static void main(String[] args) {
		BaseballGame baseballSet = new BaseballGame();
		baseballSet.startBaseballGame();
	}

}