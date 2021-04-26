package NumberBaseBallGame.generater;

import NumberBaseBallGame.domain.Ball;
import NumberBaseBallGame.domain.BallNumberMatchResult;

import java.util.List;

public class BallNumberMatcher {

	public BallNumberMatchResult matchNumber(List<Ball> clientBalls, List<Ball> targetBalls){
		return new BallNumberMatchResult(
				matchStrike(clientBalls, targetBalls)
				,matchBall(clientBalls, targetBalls)
		);
	}
	private int matchStrike(List<Ball> clientBalls, List<Ball> targetBalls){
		int gameLength = targetBalls.size();
		int strikeCount = 0;
		for(int i = 0; i < gameLength; i++){
			strikeCount = targetBalls.get(i).equals(clientBalls.get(i)) ? ++strikeCount :strikeCount;
		}
		return strikeCount;
	}

	private int matchBall(List<Ball> clientBalls, List<Ball> targetBalls){
		int gameLength = targetBalls.size();
		int ballCount = 0;
		for(int i = 0; i < gameLength; i++){
			ballCount = containButNotEqual(i, clientBalls.get(i), targetBalls) ? ++ballCount :ballCount;
		}
		return ballCount;
	}
	private boolean containButNotEqual(int index,Ball ball, List<Ball> targetBalls){
		boolean contains = targetBalls.contains(ball);
		if (contains){
			int indexOf = targetBalls.indexOf(ball);
			return indexOf!= index;
		}
		return false;
	}

}
