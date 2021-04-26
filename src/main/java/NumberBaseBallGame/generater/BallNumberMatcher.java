package NumberBaseBallGame.generater;

import NumberBaseBallGame.domain.BallNumberMatchResult;
import NumberBaseBallGame.domain.BaseBallConst;

public class BallNumberMatcher {
	private final int GAMENUMBERS_LENGTH= BaseBallConst.GAMENUMBERS_LENGTH;

	public BallNumberMatchResult matchNumber(){
		return new BallNumberMatchResult(
				matchStrike()
				,matchBall()
		);
	}
	private int matchStrike(){
		return 0;
	}

	private int matchBall(){
		return 0;
	}
}
