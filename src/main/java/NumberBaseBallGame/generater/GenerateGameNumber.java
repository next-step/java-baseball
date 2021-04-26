package NumberBaseBallGame.generater;

import NumberBaseBallGame.domain.Ball;

import java.util.ArrayList;
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
			i += checkDuplicate(randomBalls,aRandomNumber) ? 0 : -1;
		}
		return randomBalls;
	}
	private boolean checkDuplicate(List<Ball> randomBalls, int aRandomNumber){
		Ball aBall = new Ball(aRandomNumber);
		if(!randomBalls.contains(aBall)){
			setBallValueNumber(randomBalls, aBall);
			return true;
		}
		return false;
	}

	private void setBallValueNumber(List<Ball> randomBalls, Ball aBall) {
		randomBalls.add(aBall);
	}
}
