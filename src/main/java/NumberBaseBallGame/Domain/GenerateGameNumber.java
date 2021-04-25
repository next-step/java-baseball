package NumberBaseBallGame.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenerateGameNumber {
	private final int gameBallLength;
	private List<Ball> randomBalls;

	public GenerateGameNumber(int GAMENUMBERS_LENGTH) {
		this.gameBallLength = GAMENUMBERS_LENGTH;
		this.randomBalls = generateGameNumber();
	}

	public List<Ball> getRandomBalls() {
		return randomBalls;
	}

	/**
	 * 대결용 임의의 수 1 ~ 9 사이 서로다른 Random 수 3개
	 *
	 * @return
	 */
	private List<Ball> generateGameNumber(){
		randomBalls = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < gameBallLength; i++){
			int aRandomNumber = random.nextInt(9)+1;
			setBallValueNumber(randomBalls,aRandomNumber);
		}
		return randomBalls;
	}

	private void setBallValueNumber(List<Ball> randomBalls, int aRandomNumber) {
		if(!randomBalls.contains(aRandomNumber)){
			Ball aBall = new Ball();
			aBall.setValueNumber(aRandomNumber);
			randomBalls.add(aBall);
		}
	}
}
