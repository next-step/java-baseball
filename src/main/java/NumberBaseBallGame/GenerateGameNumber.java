package NumberBaseBallGame;

import java.util.Random;

public class GenerateGameNumber {
	private final int GAMENUMBERS_LENGTH;

	public GenerateGameNumber(int GAMENUMBERS_LENGTH) {
		this.GAMENUMBERS_LENGTH = GAMENUMBERS_LENGTH;
	}

	/**
	 * 대결용 임의의 수 1 ~ 9 사이 서로다른 Random 수 3개
	 *
	 * @return
	 */
	public int[] generateGameNumber(){
		int[] gameNumbers = new int[GAMENUMBERS_LENGTH];
		Random random = new Random();
		out:
		for (int i = 0; i < GAMENUMBERS_LENGTH; i++){
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
