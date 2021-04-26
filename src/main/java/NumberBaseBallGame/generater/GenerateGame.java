package NumberBaseBallGame.generater;

import NumberBaseBallGame.domain.BallNumberMatchResult;
import NumberBaseBallGame.domain.BaseBallConst;
import NumberBaseBallGame.domain.Ball;
import NumberBaseBallGame.ValidationCheckUtils;

import java.util.List;

public class GenerateGame {
	private final List<Ball> randomBalls;
	private final GenerateClientBall pickClientBalls;
	private final BallNumberMatcher ballNumberMatcher;
	private final int GAMENUMBERS_LENGTH= BaseBallConst.GAMENUMBERS_LENGTH;

	public GenerateGame() {
		randomBalls = new GenerateGameNumber(GAMENUMBERS_LENGTH).getRandomBalls();
		ballNumberMatcher = new BallNumberMatcher(GAMENUMBERS_LENGTH);
		pickClientBalls = new GenerateClientBall(GAMENUMBERS_LENGTH);
	}

	/**
	 * 게임 시작!
	 *  사용자 입력과 게임 값을 비교
	 *
	 * @param getClientNumber
	 * @return
	 */
	public BallNumberMatchResult playGame(String getClientNumber){
		ValidationCheckUtils.checkInputNumber(getClientNumber);

		List<Ball> clientBalls = pickClientBalls.generateBall(getClientNumber);

		return ballNumberMatcher.matchNumber(clientBalls, randomBalls);
	}
}
