package baseball;

public class BaseballGame {

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
			i = dupCheckNumArray(randomArray, i);
		}

		return randomArray;
	}

	/**
	 * 야구게임 사용자 입력 번호 추출
	 *
	 * @return int[]
	 */
	public int[] getInputNum() {
		int[] inputNumArray = new int[3];

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

		return gameResult;
	}

	/**
	 * 랜덤 숫자 중복 체크
	 *
	 * @param checkArray
	 * @param checkIndex
	 * @return int
	 */
	public int dupCheckNumArray(int[] checkArray, int checkIndex) {
		int index = checkIndex;
		for (int i = 0; i < checkIndex; i++) {
			//이전 값과 비교하여 값이 중복일때 랜덤 배열 index -1
			index = index - equalToNum(checkArray[checkIndex], checkArray[i]);
		}
		return index;
	}

	/**
	 * 숫자 비교
	 * 같을 때 1 다를 때 0 return
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

	public static void main(String[] args) {
		BaseballGame baseballSet = new BaseballGame();
		baseballSet.startBaseballGame();
	}

}