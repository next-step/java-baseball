package numberBaseBallGame.generator;

import numberBaseBallGame.domain.Ball;

import java.util.ArrayList;
import java.util.List;

public class GenerateClientBall {
	private final int gameBallLength;

	public GenerateClientBall(int gameBallLength) {
		this.gameBallLength = gameBallLength;
	}

	public List<Ball> generateBall(String getClientNumber){
		List<Ball> balls = new ArrayList<>();

		for (char item : getClientNumber.toCharArray()){

			Ball aBall = new Ball(Integer.parseInt(String.valueOf(item)));
			balls.add(aBall);

		}
		return balls;
	}
}
