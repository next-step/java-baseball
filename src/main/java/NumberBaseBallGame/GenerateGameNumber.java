package NumberBaseBallGame;

import java.util.Arrays;
import java.util.Random;

public class GenerateGameNumber {
	private final int gamenuberLength;
	private int[] gameNumbers;

	public GenerateGameNumber(int GAMENUMBERS_LENGTH) {
		this.gamenuberLength = GAMENUMBERS_LENGTH;
		gameNumbers = new int[gamenuberLength];
	}

	/**
	 * 대결용 임의의 수 1 ~ 9 사이 서로다른 Random 수 3개
	 *
	 * @return
	 */
	public int[] generateGameNumber(){
		Random random = new Random();
		for (int i = 0; i < gamenuberLength; i++){
			int aRandomNumber = random.nextInt(9)+1;
			i = checkNextIter(aRandomNumber,i);
		}
		return gameNumbers;
	}
	private int checkNextIter(int aRandomNumber, int i){
		if(checkDuplicate(aRandomNumber)){
			i--;
		}
		if(!checkDuplicate(aRandomNumber)){
			gameNumbers[i] = aRandomNumber;
		}
		return i;
	}
	private boolean checkDuplicate(int aRandomNum){
		for (int item : gameNumbers) if(item == aRandomNum) return true;
		return false;
	}
}
