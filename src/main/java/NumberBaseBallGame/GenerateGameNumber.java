package NumberBaseBallGame;

import java.util.Random;

public class GenerateGameNumber {
	/**
	 * 대결용 임의의 수 1 ~ 9 사이 서로다른 Random 수 3개
	 *
	 * @return
	 */
	public int[] generateGameNumber(){
		int[] gameNumbers = new int[3];
		Random random = new Random();
		out:
		for (int i = 0; i < gameNumbers.length; i++){
			int aRandomNumber = random.nextInt(10);

			for(int item : gameNumbers){
				if(aRandomNumber == item){
					i--;
					continue out;
				}
			}
			gameNumbers[i] = aRandomNumber;
		}
		return gameNumbers;
	}
}
