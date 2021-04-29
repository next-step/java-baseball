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
		if(getClientNumber.length() != gameBallLength){
			throw new IllegalArgumentException(gameBallLength+"글자만 입력해주세요. example : 123, 456 ");
		}
		List<Ball> balls = new ArrayList<>();
		for (char item : getClientNumber.toCharArray()){

			Ball ball = new Ball(Integer.parseInt(String.valueOf(item)));
			balls.add(ball);

		}
		return balls;
	}
}
