package validator;

import constant.GameRules;

/**
 * Enum으로 구현한 게임의 룰 규칙에 맞는 지 점검
 */
public class GameRulesValidator {
	public boolean checkSuccess(int strikeCnt, int ballCnt) {
		return GameRules.Success.getCheck().test(strikeCnt, ballCnt);
	}

	public boolean checkStrike(int strikeCnt, int ballCnt) {
		return GameRules.Strike.getCheck().test(strikeCnt, ballCnt);
	}

	public boolean checkBall(int strikeCnt, int ballCnt) {
		return GameRules.Ball.getCheck().test(strikeCnt, ballCnt);
	}

	public boolean checkNothing(int strikeCnt, int ballCnt) {
		return GameRules.Nothing.getCheck().test(strikeCnt, ballCnt);
	}
}
