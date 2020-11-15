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

	public static void main(String[] args) {
		BaseballGame baseballSet = new BaseballGame();
		baseballSet.startBaseballGame();
	}

}