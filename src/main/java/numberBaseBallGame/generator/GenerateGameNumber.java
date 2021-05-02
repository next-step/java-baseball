package numberBaseBallGame.generator;

import numberBaseBallGame.domain.Ball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateGameNumber {
	private final int GAMENUMBERS_LENGTH;

	private List<Ball> randomBalls;

	public GenerateGameNumber(int GAMENUMBERS_LENGTH) {
		this.GAMENUMBERS_LENGTH = GAMENUMBERS_LENGTH;
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
		for (int i = 0; i < GAMENUMBERS_LENGTH; i++){
			int randomNumber = random.nextInt(9)+1;
			i += checkDuplicate(randomBalls, randomNumber) ? 0 : -1;
		}

		return randomBalls;
	}

	private boolean checkDuplicate(List<Ball> randomBalls, int aRandomNumber){
		Ball ball = new Ball(aRandomNumber);
		if(!randomBalls.contains(ball)){
			setBallValueNumber(randomBalls, ball);

			return true;
		}
		return false;
	}

	private void setBallValueNumber(List<Ball> randomBalls, Ball aBall) {
		randomBalls.add(aBall);
	}
}
