package NumberBaseBallGame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PlayGame {
	private final int[] gameNumbers;
	private final int GAMENUMBERS_LENGTH= 3;

	public PlayGame() {
		gameNumbers = new GenerateGameNumber(GAMENUMBERS_LENGTH).generateGameNumber();
	}

	public int[] getGameNumbers() {
		return gameNumbers;
	}

	/**
	 * 게임 시작!
	 *  사용자 입력과 게임 값을 비교
	 *
	 * @param getNumbers
	 * @return
	 */
	public GameHintAndResults playGame(String getNumbers){
		ValidationCheckUtils.checkValidation(getNumbers);

		int[] clientNumber = parseCharToInt(getNumbers.toCharArray());

		int strike = checkStrike(clientNumber);
		int ball = checkBall(clientNumber);

		String hint = "";
		if(strike >0){
			hint+= "스트라이크 "+strike+"볼";
		}

		if(ball >0){
			hint+= ball+"볼";
		}
		if(strike==0 && ball ==0){
			hint = "낫싱";
		}

		GameHintAndResults result = new GameHintAndResults();
		result.setHint(hint);
		if(strike == GAMENUMBERS_LENGTH){
			result.setFinish(true);
		}
		return result;
	}


	/**
	 * 스트라이크 체크
	 *
	 * @param clientNumber
	 * @return
	 */
	private int checkStrike(int[] clientNumber){
		int result = 0;
		for(int i = 0; i < GAMENUMBERS_LENGTH; i++){
			if(gameNumbers[i] == clientNumber[i]){
				result++;
			}
		}
		return result;
	}

	/**
	 * 볼 체크
	 *
	 * @param clientNumber
	 * @return
	 */
	private int checkBall(int[] clientNumber){
		int result = 0;
		for(int i = 0; i < GAMENUMBERS_LENGTH; i++){
			if(gameNumbers[i] == clientNumber[i]) continue;
			try{
				Arrays.binarySearch(gameNumbers, clientNumber[i]);
				result++;
			}catch (ArrayIndexOutOfBoundsException e){
				System.out.println("찾는요소없음.");
			}
		}
		return result;
	}

	private int[] parseCharToInt(char[] chars){
		int[] ints = new int[GAMENUMBERS_LENGTH];

		for(int i =0 ; i< GAMENUMBERS_LENGTH; i++){
			ints[i] = Integer.parseInt(String.valueOf(chars[i]));
		}
		return ints;
	}

}
