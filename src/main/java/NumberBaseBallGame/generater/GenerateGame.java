package NumberBaseBallGame.generater;

import NumberBaseBallGame.domain.BallNumberMatchResult;
import NumberBaseBallGame.domain.BaseBallConst;
import NumberBaseBallGame.domain.Ball;
import NumberBaseBallGame.domain.ValidationCheckUtils;

import java.util.ArrayList;
import java.util.List;

public class GenerateGame {
	private final List<Ball> randomBalls;
	private final BallNumberMatcher ballNumberMatcher;
	private final int GAMENUMBERS_LENGTH= BaseBallConst.GAMENUMBERS_LENGTH;

	public GenerateGame() {
		randomBalls = new GenerateGameNumber(GAMENUMBERS_LENGTH).getRandomBalls();
		ballNumberMatcher = new BallNumberMatcher();
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

		List<Ball> clientBalls = generateClientBalls(getClientNumber);

		return checkMatch(clientBalls);
	}

	private BallNumberMatchResult checkMatch(List<Ball> clientBalls) {
		return ballNumberMatcher.matchNumber(clientBalls, randomBalls);
	}

	/**
	 * 고객 Ball 생성
	 *  TODO : 행위 분리
	 *
	 * @param getClientNumber
	 * @return
	 */
	private List<Ball> generateClientBalls(String getClientNumber) {
		List<Ball> balls = new ArrayList<>();
		for (char item : getClientNumber.toCharArray()){
			Ball aBall = new Ball(item);
			balls.add(aBall);
		}
		return balls;
	}

}
